package com.dzen.campfire.api.tools.server

import com.dzen.campfire.api.tools.ApiAccount
import com.dzen.campfire.api.tools.ApiException
import com.sup.dev.java.classes.collections.Cash
import com.dzen.campfire.api.tools.client.ApiClient
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.debug.err
import com.sup.dev.java.libs.debug.info
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.tools.ToolsBytes
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
        private val portCertificate: Int,
        private val botTokensList: Array<String>,
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


    fun startServerHTTPS() {
        val server = HTTPSServer(keyBytesJKS, keyBytesBKS, keyPassword, portHttps, portCertificate) { socket ->
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
            val inputStream = DataInputStream(socket.getInputStream())

            var l = inputStream.readInt()

            var isHttpFormat = false;
            val json =
            if(l == 1347375956){
                isHttpFormat = true
                val inp = BufferedReader(InputStreamReader(socket.getInputStream()))
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
                Json(String(chars))
            } else {
                isHttpFormat = false
                val bytes = ByteArray(l)
                inputStream.readFully(bytes, 0, l)
                Json(bytes)
            }

            parseConnection(
                    socket, json,
                    onKeyFounded = { key = it },
                    jsonResponse = { writeHttps(socket.getOutputStream(), it, isHttpFormat) },
                    dataResponse = { writeData(socket.getOutputStream(), it, isHttpFormat) },
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

    fun writeHttps(os: OutputStream, json: Json, isHttpFormat: Boolean) {
        if(isHttpFormat){
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
        }else{
            val dos = DataOutputStream(os)
            val bytes = json.toBytes()
            dos.writeInt(bytes.size)
            dos.write(bytes)
            dos.flush()
        }
    }

    fun writeData(os: OutputStream, bytes: ByteArray, isHttpFormat: Boolean) {
        if(isHttpFormat){
            val out = BufferedWriter(OutputStreamWriter(os))

            out.write("HTTP/1.0 200 OK\r\n")
            out.write("Access-Control-Allow-Origin: *\r\n")
            out.write("Access-Control-Allow-Credentials: true\r\n")
            out.write("Access-Control-Allow-Headers: *\r\n")
            out.write("Access-Control-Allow-Methods: *\r\n")
            out.write("Content-Length: ${bytes.size}\r\n")
            out.write("\r\n")
            out.flush()
            os.write(bytes)
            os.flush()

        } else {
            val dos = DataOutputStream(os)
            dos.writeInt(bytes.size)
            dos.write(bytes)
            dos.flush()
        }
    }

    //
    //  Parsing
    //

    private val ips = HashMap<String, ArrayList<Long>>()
    private var lastIpsClear = 0L
    private var ipRuntimeLastClear = 0L
    private val ipRuntimeWatchTime = 1000L * 60 * 5
    private val ipRuntimeMaxPercent = 0.30
    private val ipsRuntime = HashMap<String, Long>()
    private val ipRuntimeBanTime = 1000L * 60 * 60 * 1
    private val ipRuntimeBanList = HashMap<String, Long>()
    private val ipSynchronizedList = HashMap<String, String>()

    private fun parseConnection(socket: Socket, json: Json,
                                onKeyFounded: (String)->Unit,
                                jsonResponse: (Json)->Unit,
                                dataResponse: (ByteArray)->Unit,
    ) {
        val ip:String = socket.inetAddress.hostAddress

        synchronized(ipRuntimeBanList){
            if(ipRuntimeBanList[ip]?:0L > System.currentTimeMillis()){
                info("Ip blocked by runtime ip[$ip]")
                return
            }
        }
        synchronized(ipSynchronizedList){
            ipSynchronizedList[ip] = ip
        }

        synchronized(ipSynchronizedList[ip]?:"none"){
            val request = requestFactory.instanceRequest(json)
            val key = "[${request.requestProjectKey}] ${request.javaClass.simpleName}"
            onKeyFounded.invoke(key)
            request.accessToken = json.get(ApiClient.J_API_ACCESS_TOKEN)
            request.refreshToken = json.get(ApiClient.J_API_REFRESH_TOKEN)
            request.loginToken = json.get(ApiClient.J_API_LOGIN_TOKEN)
            request.botToken = json.get(ApiClient.J_API_BOT_TOKEN)

            val apiAccount = accountProvider.getAccount(request.accessToken, request.refreshToken, request.loginToken)
            request.apiAccount = apiAccount ?: ApiAccount()


            if(!botTokensList.contains(request.botToken)) {
                synchronized(ips) {
                    if (request.apiAccount.id > 0) {
                        if (lastIpsClear < System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 7) {
                            lastIpsClear = System.currentTimeMillis()
                            ips.clear()
                        }
                        var list = ips[ip]
                        if (list == null) {
                            list = ArrayList()
                            ips[ip] = list
                        }
                        if (!list.contains(request.apiAccount.id)) {
                            list.add(request.apiAccount.id)
                        }
                        if (list.size > 5) {
                            return
                        }
                    }
                }
            }


            val t = System.currentTimeMillis()
            if (request.requestType == ApiClient.REQUEST_TYPE_REQUEST) jsonResponse.invoke(parseRequestConnection(socket, request, apiAccount))
            if (request.requestType == ApiClient.REQUEST_TYPE_DATA_LOAD) dataResponse.invoke(parseDataOutConnection(request)!!)

            val tt = System.currentTimeMillis() - t
            statisticCollector.invoke(key, tt, request.requestApiVersion)
            info("[${request.requestProjectKey}] ${apiAccount?.name ?: "null"} [$ip]${if(request.botToken != null)" BOT[${request.botToken}]" else ""} ${request.javaClass.simpleName} $tt ms runtime[${((ipsRuntime[ip]?:0L).toDouble()/ipRuntimeWatchTime*100).toInt()}%]")


            synchronized(ipsRuntime) {
                if (ipRuntimeLastClear < System.currentTimeMillis() - ipRuntimeWatchTime) {
                    ipRuntimeLastClear = System.currentTimeMillis()
                    ipsRuntime.clear()
                }
                ipsRuntime[ip] = (ipsRuntime[ip] ?: 0L) + tt
                if ((ipsRuntime[ip] ?: 0L).toDouble() / ipRuntimeWatchTime > ipRuntimeMaxPercent) {
                    synchronized(ipRuntimeBanList){
                        ipRuntimeBanList[ip] = System.currentTimeMillis() + ipRuntimeBanTime
                    }
                }
            }
        }
    }

    private fun parseRequestConnection(socket: Socket, request: Request<*>, apiAccount: ApiAccount?): Json {

        if (request.dataOutput.isNotEmpty()) {
            val inputStream = DataInputStream(socket.getInputStream())
            for (i in request.dataOutput.indices) if (request.dataOutput[i] != null) inputStream.readFully(request.dataOutput[i], 0, request.dataOutput[i]!!.size)
            request.updateDataOutput()
        }
        if(request.dataOutputBase64.isNotEmpty()){
            request.dataOutput = arrayOfNulls(request.dataOutputBase64.size)
            for(index in request.dataOutputBase64.indices){
                request.dataOutput[index] = ToolsBytes.fromBase64(request.dataOutputBase64[index]?:"")
            }
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
