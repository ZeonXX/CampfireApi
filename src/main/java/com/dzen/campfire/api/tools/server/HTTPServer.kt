package com.dzen.campfire.api.tools.server

import com.sup.dev.java.libs.debug.Debug
import com.sup.dev.java.libs.debug.info
import com.sup.dev.java.libs.debug.log
import com.sup.dev.java.tools.ToolsMapper
import com.sup.dev.java.tools.ToolsThreads
import java.io.*
import java.lang.Exception
import java.net.ServerSocket
import java.net.Socket

class HTTPServer(
    private val portHTTP: Int,
    private val onNextConnection: (Socket) -> Unit
) {

    var threadProvider: (() -> Unit) -> Unit = { ToolsThreads.thread { it.invoke() } }
    var onConnectionError: (Throwable) -> Unit = { Debug.logPrint(it) }
    var onServerError: (Throwable) -> Unit = { Debug.logPrint(it) }
    private var stop = false

    fun startServer() {
        stop = false
        startHTTP()
    }

    private fun stop() {
        stop = true
    }

    private val ips = HashMap<String, ArrayList<Long>>()
    private val blockList = ArrayList<String>()
    private var lastIpsClear = 0L
    private var lastBlockClear = 0L

    private fun checkConnection(socket:Socket):Boolean{
        val ip:String = socket.inetAddress.hostAddress
        if(ip.isNotEmpty()){
            if(lastIpsClear < System.currentTimeMillis() - 1000L * 60 * 2){
                lastIpsClear = System.currentTimeMillis()
                ips.clear()
            }
            if(lastBlockClear < System.currentTimeMillis() - 1000L * 60 * 60 * 1){
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
            if(list.size > 300){
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
    //  Http
    //

    private fun startHTTP() {

        ToolsThreads.thread {
            try {
                val serverSocket = ServerSocket(portHTTP)
                while (!stop) {
                    val socket = serverSocket.accept()
                    if (stop) return@thread

                    if(!checkConnection(socket)){
                        continue
                    }

                    socket.soTimeout = 3000

                    threadProvider.invoke {
                        if (stop) return@invoke
                        try {
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

}
