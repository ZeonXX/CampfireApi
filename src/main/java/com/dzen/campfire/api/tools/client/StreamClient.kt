package com.dzen.campfire.api.tools.client

import com.dzen.campfire.api.tools.StreamClientHandshake
import com.dzen.campfire.api.tools.StreamServerHandshake
import com.sup.dev.java.classes.items.Connections
import com.sup.dev.java.libs.debug.err
import com.sup.dev.java.libs.debug.info
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.tools.ToolsCollections
import com.sup.dev.java.tools.ToolsThreads
import java.io.DataInputStream
import java.io.DataOutputStream

class StreamClient(
    private val tokenProvider: TokenProvider,
    private val host: String,
    private val portHttps: Int,
    private val portCertificate: Int
) : HTTPSClient(host, portHttps, portCertificate) {
    private var connections: Connections? = null
    var onMessage: (Json) -> Unit = {}
    var subscriptions: Array<Long> = emptyArray()

    fun streamConnect() {
        ToolsThreads.thread {
            try {
                connections?.close()
                connections = connect()
            } catch (e: Exception) {
                ToolsThreads.sleep(1000)
                streamConnect()
                return@thread
            }
            handshake()
        }
    }

    private fun handshake() {
        tokenProvider.getToken { loginToken ->
            try {
                info("StreamClient: handshake start client")
                val req = StreamClientHandshake()
                req.loginToken = loginToken
                req.subscribe = subscriptions
                val ba = req.json(true, Json()).toBytes()

                val out = DataOutputStream(connections!!.out)
                val inp = DataInputStream(connections!!.input)
                out.writeInt(ba.size)
                out.write(ba)

                info("StreamClient: handshake start server")
                val l = inp.readInt()
                val ba2 = ByteArray(l)
                inp.readFully(ba2)
                val resp = StreamServerHandshake()
                resp.json(false, Json(ba2))

                when (resp.error) {
                    StreamServerHandshake.SUCCESS -> {
                        info("StreamClient: handshake success")
                    }
                    StreamServerHandshake.E_UNAUTHORIZED -> {
                        info("StreamClient: handshake unauthorized")
                        tokenProvider.onLoginFailed()
                        return@getToken
                    }
                    StreamServerHandshake.E_SUB_AMOUNT -> {
                        info("StreamClient: handshake subscription amount")
                        subscriptions = subscriptions.copyOfRange(0, subscriptions.size.coerceAtMost(50))
                        streamConnect()
                        return@getToken
                    }
                    StreamServerHandshake.E_ALREADY -> {
                        info("StreamClient: handshake already")
                        connections = null
                        return@getToken
                    }
                    else -> {
                        info("StreamClient: handshake unknown")
                        connections = null
                        return@getToken
                    }
                }

                while (true) {
                    val l2 = inp.readInt()
                    info("StreamClient: message ${l2}B")
                    val ba3 = ByteArray(l2)
                    inp.readFully(ba3)
                    onMessage(Json(ba3))
                }
            } catch (e: Exception) {
                err(e)
                ToolsThreads.sleep(1000)
                streamConnect()
            }
        }
    }

    fun subscribe(id: Long) {
        subscriptions += id
        streamConnect()
    }
    fun unsubscribe(id: Long) {
        subscriptions = ToolsCollections.removeItem(id, subscriptions)
        streamConnect()
    }

    fun suicide() {
        connections?.close()
    }
}