package com.dzen.campfire.api.tools.server

import com.sup.dev.java.libs.debug.Debug
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
