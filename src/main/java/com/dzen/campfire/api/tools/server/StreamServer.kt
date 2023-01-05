package com.dzen.campfire.api.tools.server

import com.dzen.campfire.api.tools.ApiAccount
import com.dzen.campfire.api.tools.StreamClientHandshake
import com.dzen.campfire.api.tools.StreamServerHandshake
import com.sup.dev.java.libs.debug.err
import com.sup.dev.java.libs.debug.info
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.tools.ToolsThreads
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket

data class Stream(
    val apiAccount: ApiAccount,
    val socket: Socket,
    val inputStream: DataInputStream,
    val outputStream: DataOutputStream,
    val subscriptions: Array<Long>,
) {
    fun sendJson(json: Json) {
        StreamServer.sendJson(outputStream, json)
    }
}

class StreamServer(
    private val accountProvider: AccountProvider,
    private val keyBytesJKS: ByteArray,
    private val keyBytesBKS: ByteArray,
    private val keyPassword: String,
    private val portStream: Int,
) : HTTPSServer(keyBytesJKS, keyBytesBKS, keyPassword, portStream, 0, onNextConnection = {}) {
    val byAccount: HashMap<Long, Stream> = hashMapOf()

    init {
        onNextConnection = {
            handleConnection(it)
        }
    }

    private fun handleConnection(socket: Socket) {
        val inp = DataInputStream(socket.getInputStream())
        val out = DataOutputStream(socket.getOutputStream())

        val l1 = inp.readInt()
        val b1 = ByteArray(l1)
        inp.readFully(b1)
        val req = StreamClientHandshake()
        req.json(false, Json(b1))

        val account = accountProvider.getAccount(null, null, req.loginToken)
        if (account == null) {
            sendJson(out, StreamServerHandshake().let {
                it.error = StreamServerHandshake.E_UNAUTHORIZED
                it.json(true, Json())
            })
            socket.close()
            return
        }

        if (req.subscribe.size > 50) {
            sendJson(out, StreamServerHandshake().let {
                it.error = StreamServerHandshake.E_SUB_AMOUNT
                it.json(true, Json())
            })
            socket.close()
            return
        }

        if (byAccount[account.id] != null) {
            sendJson(out, StreamServerHandshake().let {
                it.error = StreamServerHandshake.E_ALREADY
                it.json(true, Json())
            })
            socket.close()
            return
        }

        byAccount[account.id] = Stream(
            apiAccount = account,
            socket = socket,
            inputStream = inp,
            outputStream = out,
            subscriptions = req.subscribe,
        )
        sendJson(out, StreamServerHandshake().let {
            it.error = StreamServerHandshake.SUCCESS
            it.json(true, Json())
        })
        info("StreamServer connected id=${account.id} name=${account.name} ip=${socket.inetAddress.hostAddress}")

        ToolsThreads.thread {
            try {
                socket.soTimeout = 0
                while (inp.read() != -1) {

                }
            } catch (e: Exception) {
                err(e)
            } finally {
                socket.close()
                info("StreamServer disconnected id=${account.id} name=${byAccount[account.id]?.apiAccount?.name}")
                byAccount.remove(account.id)
            }
        }
    }

    companion object {
        internal fun sendJson(outputStream: DataOutputStream, json: Json) {
            val ba = json.toBytes()
            outputStream.writeInt(ba.size)
            outputStream.write(ba)
        }
    }
}
