package com.dzen.campfire.api.tools.server

import com.sup.dev.java.libs.debug.Debug
import com.sup.dev.java.libs.debug.info
import com.sup.dev.java.libs.debug.log
import com.sup.dev.java.tools.ToolsThreads
import java.io.*
import java.lang.Exception
import java.net.ServerSocket
import java.net.Socket
import java.security.KeyStore

import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLServerSocket
import javax.net.ssl.SSLSocket
import javax.net.ssl.TrustManagerFactory

class HTTPSServer(
        private val keyBytesJKS: ByteArray,
        private val keyBytesBKS: ByteArray,
        private val keyPassword: String,
        private val portHTTPS: Int,
        private val portCertificate: Int,
        private val onNextConnection: (Socket) -> Unit
) {

    var threadProvider: (() -> Unit) -> Unit = { ToolsThreads.thread { it.invoke() } }
    var onConnectionError: (Throwable) -> Unit = { Debug.logPrint(it) }
    var onServerError: (Throwable) -> Unit = { Debug.logPrint(it) }
    private val keyPasswordBytes = keyPassword.toByteArray()
    private var stop = false

    fun startServer() {
        stop = false

        startCertificate()
        startHTTPS()
    }

    private fun stop() {
        stop = true
    }

    private val ips = HashMap<String, ArrayList<Long>>()
    private val blockList = ArrayList<String>()
    private var lastIpsClear = 0L
    private var lastBlockClear = 0L

    private fun checkConnection(socket:Socket):Boolean{
        val ip:String = socket.inetAddress.canonicalHostName
        if(ip.isNotEmpty()){
            if(lastIpsClear < System.currentTimeMillis() - 1000L * 60){
                lastIpsClear = System.currentTimeMillis()
                ips.clear()
            }
            if(lastBlockClear < System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 30){
                lastBlockClear = System.currentTimeMillis()
                blockList.clear()
            }
            if(blockList.contains(ip)){
                info("> Block connection ip[$ip]")
                try {
                    socket.close()
                }catch(e:Exception){

                }
                return  false
            }
            var list = ips[ip]
            if(list == null){
                list = ArrayList()
                ips[ip] = list
            }
            if(list.size > 100){
                info("> Block connection ip[$ip]")
                blockList.add(ip)
                try {
                    socket.close()
                }catch(e:Exception){

                }
                return false
            }
            list.add(0)
        }
        return true
    }

    //
    //  Certificate
    //

    private fun startCertificate() {

        ToolsThreads.thread {
            try {
                val serverSocket = ServerSocket(portCertificate)
                while (!stop) {
                    val socket = serverSocket.accept()
                    if (stop) return@thread

                    if(!checkConnection(socket)){
                        continue
                    }

                    threadProvider.invoke {
                        if (stop) return@invoke
                        try {
                            parseCertificateConnection(socket)
                            socket.close()
                        } catch (e: Exception) {
                            onConnectionError.invoke(e)
                        }
                    }

                }
            } catch (e: Throwable) {
                onServerError.invoke(e)
                stop()
            }
        }
    }

    private fun parseCertificateConnection(socket: Socket) {
        val dos = DataOutputStream(socket.getOutputStream())
        dos.writeInt(keyBytesBKS.size)
        dos.writeInt(keyPasswordBytes.size)
        dos.write(keyBytesBKS)
        dos.write(keyPasswordBytes)
        dos.flush()
    }

    //
    //  Https
    //


    private fun startHTTPS() {

        ToolsThreads.thread {
            try {
                val serverSocket = instanceSocket()
                while (!stop) {
                    val socket = serverSocket.accept() as SSLSocket

                    if (stop) return@thread

                    if(!checkConnection(socket)){
                        continue
                    }

                    socket.soTimeout = 3000

                    threadProvider.invoke {
                        if (stop) return@invoke
                        try {
                            socket.enabledCipherSuites = socket.supportedCipherSuites
                            socket.startHandshake()
                            onNextConnection.invoke(socket)
                        } catch (e: Exception) {
                            onConnectionError.invoke(e)
                        }
                    }

                }
            } catch (e: Throwable) {
                onServerError.invoke(e)
                stop()
            }
        }

    }

    private fun instanceSocket(): SSLServerSocket {

        val keyStore = KeyStore.getInstance("JKS")
        keyStore.load(ByteArrayInputStream(keyBytesJKS), keyPassword.toCharArray())

        val keyManagerFactory = KeyManagerFactory.getInstance("SunX509")
        keyManagerFactory.init(keyStore, keyPassword.toCharArray())
        val km = keyManagerFactory.keyManagers

        val trustManagerFactory = TrustManagerFactory.getInstance("SunX509")
        trustManagerFactory.init(keyStore)
        val tm = trustManagerFactory.trustManagers

        val sslContext = SSLContext.getInstance("TLSv1")
        sslContext.init(km, tm, null)

        return sslContext.serverSocketFactory.createServerSocket(portHTTPS) as SSLServerSocket
    }


}
