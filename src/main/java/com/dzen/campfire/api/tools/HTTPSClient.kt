package com.dzen.campfire.api.tools

import com.sup.dev.java.classes.items.Connections
import com.sup.dev.java.libs.debug.err
import com.sup.dev.java.tools.ToolsThreads
import java.io.ByteArrayInputStream
import java.io.DataInputStream
import java.net.Socket
import java.security.KeyStore
import javax.net.ssl.*


class HTTPSClient(
        private val host: String,
        private val portHttps: Int,
        private val portCertificate: Int
) {

    var keyStoreType = "BKS"
    var keyManagerFactoryType = "PKIX"
    var trustManagerFactoryType = "PKIX"
    var certificate:ByteArray?=null
    var certificatePassword=""
    private var sslContext:SSLContext? = null

    fun connect(tryCount:Int = 5): Connections {
        try {
            if (sslContext == null) connectCertificate()
            return connectHttps()
        }catch(e:Exception){
            if(tryCount > 0 && e is IllegalStateException){
                ToolsThreads.sleep(100)
                return connect(tryCount-1)
            }
            else throw e
        }
    }

    //
    //  Certificate
    //

    fun connectCertificate() {
        if(certificate == null) {
            val socket = Socket(host, portCertificate)
            socket.soTimeout = 10000
            val dis = DataInputStream(socket.getInputStream())
            val certificateL = dis.readInt()
            val passwordL = dis.readInt()
            certificate = ByteArray(certificateL)
            val password = ByteArray(passwordL)
            dis.readFully(certificate, 0, certificateL)
            dis.readFully(password, 0, passwordL)
            certificatePassword = String(password)
            socket.close()
        }

        val keyStore = KeyStore.getInstance(keyStoreType)
        keyStore.load(ByteArrayInputStream(certificate), certificatePassword.toCharArray())

        val keyManagerFactory = KeyManagerFactory.getInstance(keyManagerFactoryType)
        keyManagerFactory.init(keyStore, certificatePassword.toCharArray())
        val km = keyManagerFactory.keyManagers

        val trustManagerFactory = TrustManagerFactory.getInstance(trustManagerFactoryType)
        trustManagerFactory.init(keyStore)
        val tm = trustManagerFactory.trustManagers

        sslContext = SSLContext.getInstance("TLSv1")
        sslContext!!.init(km, tm, null)
    }

    //
    //  Https
    //

    @Throws(Exception::class)
    private fun connectHttps(): Connections {

        val socket = sslContext!!.socketFactory.createSocket(host, portHttps) as SSLSocket
        socket.enabledCipherSuites = socket.supportedCipherSuites
        socket.startHandshake()

        return Connections(socket.outputStream, socket.inputStream){
            try {
                socket.close()
            }catch (t:Throwable){
                err(t)
            }
        }
    }

}
