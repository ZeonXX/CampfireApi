package com.dzen.campfire.api.tools.server

import com.dzen.campfire.api.tools.ApiAccount
import com.dzen.campfire.api.tools.ApiException
import com.sup.dev.java.classes.collections.Cash
import com.dzen.campfire.api.tools.client.ApiClient
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.debug.err
import com.sup.dev.java.libs.debug.info
import com.sup.dev.java.libs.debug.log
import com.sup.dev.java.libs.json.Json
import java.io.*
import java.net.Socket
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor


class ApiServer(
        private val requestFactory: RequestFactory,
        private val accountProvider: AccountProvider,
        private val keyBytesJKS: ByteArray,
        private val keyBytesBKS: ByteArray,
        private val keyPassword: String,
        private val portHttps: Int,
        private val portHttp: Int,
        private val portCertificate: Int
) {

    private val cash: Cash<Long, Json> = Cash(10000)
    private val threadPool: ThreadPoolExecutor = Executors.newCachedThreadPool() as ThreadPoolExecutor
    var onError: (String, Throwable) -> Unit = { _,ex -> err(ex) }
    var statisticCollector: (String, Long, String) -> Unit = { _, _, _ -> }

    //
    //  Server
    //

    fun startServer() {
        startServerHTTPS()
        startServerHTTP()
    }

    //
    //  HTTPS Data Stream
    //

    fun startServerHTTPS() {
        val server = HTTPSServer(keyBytesJKS, keyBytesBKS, keyPassword, portHttps, portCertificate) { socket ->
            socket.keepAlive = false
            socket.soTimeout = 3000
            threadPool.submit { parseConnectionHttps(socket) }
        }
        server.threadProvider = { threadPool.submit { it.invoke() } }
        server.onConnectionError = { err(it) }
        server.startServer()
    }

    private fun parseConnectionHttps(socket: Socket) {
        var key = "Unknown"
        try {
            val json = readHttps(socket.getInputStream())
            parseConnection(socket, json,
                onKeyFounded = {key = it},
                jsonResponse = {writeHttps(socket.getOutputStream(), it.toBytes())}
            )
        } catch (th: Throwable) {
            onError.invoke(key, th)
        } finally {
            try {
                socket.close()
            } catch (e: IOException) {
                err(e)
            }
        }
    }

    fun readHttps(inp: InputStream): Json {
        val inputStream = DataInputStream(inp)
        val l = inputStream.readInt()
        val bytes = ByteArray(l)
        inputStream.readFully(bytes, 0, l)
        return Json(bytes)
    }

    fun writeHttps(os: OutputStream, bytes: ByteArray) {
        val dos = DataOutputStream(os)
        dos.writeInt(bytes.size)
        dos.write(bytes)
        dos.flush()
    }

    //
    //  HTTP
    //

    fun startServerHTTP() {
        val server = HTTPServer(portHttp) { socket ->
            socket.keepAlive = false
            socket.soTimeout = 3000
            threadPool.submit { parseConnectionHttp(socket) }
        }
        server.threadProvider = { threadPool.submit { it.invoke() } }
        server.onConnectionError = { err(it) }
        server.startServer()
    }

    private fun parseConnectionHttp(socket: Socket) {
        var key = "Unknown"
        try {
            val inp = BufferedReader(InputStreamReader(socket.getInputStream()))
            var l = 0
            do {
                val s = inp.readLine()
                var index = s.toLowerCase().indexOf("Content-Length: ".toLowerCase())
                if(index > -1) {
                    index += "Content-Length: ".length
                    l = s.substring(index).toInt()
                }
            } while (!s.isNullOrEmpty())

            if(l == 0){
                writeHttpOptions(socket.getOutputStream())
                return
            }

            val chars = CharArray(l)
            inp.read(chars)
            val json = Json(String(chars))
            parseConnection(socket, json,
                onKeyFounded = {key = it},
                jsonResponse = {writeHttp(socket.getOutputStream(), it)}
            )
        } catch (th: Throwable) {
            onError.invoke(key, th)
        } finally {
            try {
                socket.close()
            } catch (e: IOException) {
                err(e)
            }
        }
    }

    fun writeHttpOptions(os: OutputStream) {
        val out = BufferedWriter(OutputStreamWriter(os))

        out.write("HTTP/1.0 200 OK\r\n")
        out.write("Access-Control-Allow-Origin: *\r\n")
        out.write("Access-Control-Allow-Credentials: true\r\n")
        out.write("Access-Control-Allow-Headers: *\r\n")
        out.write("Access-Control-Allow-Methods: *\r\n")
        out.write("\r\n")
        out.flush()
    }

    fun writeHttp(os: OutputStream, json: Json) {
        val body = json.toString()

        val out = BufferedWriter(OutputStreamWriter(os))

        out.write("HTTP/1.0 200 OK\r\n");
        out.write("Access-Control-Allow-Origin: *\r\n")
        out.write("Access-Control-Allow-Credentials: true\r\n")
        out.write("Access-Control-Allow-Headers: *\r\n")
        out.write("Access-Control-Allow-Methods: *\r\n")
        out.write("Content-Type: application/json\r\n")
        out.write("Content-Length: ${body.toByteArray().size}\r\n")
        out.write("\r\n")
        out.write(body)
        out.flush()
    }

    //
    //  Parsing
    //

    private fun parseConnection(socket: Socket, json: Json,
                                onKeyFounded: (String)->Unit,
                                jsonResponse: (Json)->Unit,
    ) {
        val request = requestFactory.instanceRequest(json)
        val key = "[${request.requestProjectKey}] ${request.javaClass.simpleName}"
        onKeyFounded.invoke(key)
        request.accessToken = json.get(ApiClient.J_API_ACCESS_TOKEN)
        request.refreshToken = json.get(ApiClient.J_API_REFRESH_TOKEN)
        request.loginToken = json.get(ApiClient.J_API_LOGIN_TOKEN)


        val apiAccount = accountProvider.getAccount(request.accessToken, request.refreshToken, request.loginToken)
        request.apiAccount = apiAccount ?: ApiAccount()


        val t = System.currentTimeMillis()
        if (request.requestType == ApiClient.REQUEST_TYPE_REQUEST) jsonResponse.invoke(parseRequestConnection(socket, request, apiAccount))
        if (request.requestType == ApiClient.REQUEST_TYPE_DATA_LOAD) writeHttps(socket.getOutputStream(), parseDataOutConnection(request)!!)

        val tt = System.currentTimeMillis() - t
        statisticCollector.invoke(key, tt, request.requestApiVersion)
        info("[${request.requestProjectKey}] ${apiAccount?.name ?: "null"} ${request.javaClass.simpleName} $tt ms")
    }

    private fun parseRequestConnection(socket: Socket, request: Request<*>, apiAccount: ApiAccount?): Json {

        if (request.dataOutput.isNotEmpty()) {
            val inputStream = DataInputStream(socket.getInputStream())
            for (i in request.dataOutput.indices) if (request.dataOutput[i] != null) inputStream.readFully(request.dataOutput[i], 0, request.dataOutput[i]!!.size)
            request.updateDataOutput()
        }

        var responseJson: Json?
        val responseJsonContent: Json

        if ((request.tokenRequired && apiAccount == null) || (request.tokenDesirable && apiAccount == null && (request.accessToken != null || request.refreshToken != null))) {
            responseJson = Json()
            responseJsonContent = Json()
            responseJson.put(ApiClient.J_STATUS, ApiClient.J_STATUS_ERROR)
            ApiException(ApiClient.ERROR_UNAUTHORIZED).json(true, responseJsonContent)
            responseJson.put(ApiClient.J_RESPONSE, responseJsonContent)
        } else {

            responseJson = if (request.cashAvailable) cash.get(request.dateCreated) else null

            if (responseJson == null) {

                responseJson = Json()
                responseJsonContent = Json()

                if (apiAccount != null) {
                    responseJson.put(ApiClient.J_API_ACCESS_TOKEN, apiAccount.accessToken)
                    if (request.loginToken != null || request.refreshToken != null)
                        responseJson.put(ApiClient.J_API_REFRESH_TOKEN, apiAccount.refreshToken)
                }

                try {
                    request.check()
                    request.execute().json(true, responseJsonContent)

                    responseJson.put(ApiClient.J_STATUS, ApiClient.J_STATUS_OK)
                } catch (ex: ApiException) {
                    err(ex)
                    responseJson.put(ApiClient.J_STATUS, ApiClient.J_STATUS_ERROR)
                    ex.json(true, responseJsonContent)
                }

                responseJson.put(ApiClient.J_RESPONSE, responseJsonContent)
                if (request.cashAvailable)
                    cash.put(request.dateCreated, responseJson)
            }
        }

        return responseJson
    }

    private fun parseDataOutConnection(request: Request<*>): ByteArray? {
        return request.execute().getData()
    }

}
