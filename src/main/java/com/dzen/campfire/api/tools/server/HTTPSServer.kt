package com.dzen.campfire.api.tools.server

import com.sup.dev.java.libs.debug.Debug
import com.sup.dev.java.libs.debug.info
import com.sup.dev.java.tools.ToolsThreads
import java.io.ByteArrayInputStream
import java.io.DataOutputStream
import java.net.ServerSocket
import java.net.Socket
import java.security.KeyStore
import javax.net.ssl.*

open class HTTPSServer(
        private val keyBytesJKS: ByteArray,
        private val keyBytesBKS: ByteArray,
        private val keyPassword: String,
        private val portHTTPS: Int,
        private val portCertificate: Int,
        protected var onNextConnection: (Socket) -> Unit
) {

    var threadProvider: (() -> Unit) -> Unit = { ToolsThreads.thread { it.invoke() } }
    var onConnectionError: (Throwable) -> Unit = { Debug.logPrint(it) }
    var onServerError: (Throwable) -> Unit = { Debug.logPrint(it) }
    private val keyPasswordBytes = keyPassword.toByteArray()
    private var stop = false

    fun startServer() {
        stop = false

        if (portCertificate > 0) startCertificate()
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
/*


.base/java.security.cert.CertPathBuilder.build(CertPathBuilder.java:297)
        at java.base/sun.security.validator.PKIXValidator.doBuild(PKIXValidator.java:434)
        ... 35 more
DEE, javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
XInfo, DII, [Campfire] null [185.113.38.239] EPostGet 0 ms runtime[0%]
DII, Google ID is null
XInfo, DII, [Campfire] null [185.113.38.239] EPostGet 1 ms runtime[0%]
javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
        at java.base/sun.security.ssl.Alert.createSSLException(Alert.java:131)
        at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:370)
        at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:313)
        at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:308)
        at java.base/sun.security.ssl.CertificateMessage$T13CertificateConsumer.checkServerCerts(CertificateMessage.java:1357)
        at java.base/sun.security.ssl.CertificateMessage$T13CertificateConsumer.onConsumeCertificate(CertificateMessage.java:1232)
        at java.base/sun.security.ssl.CertificateMessage$T13CertificateConsumer.consume(CertificateMessage.java:1175)
        at java.base/sun.security.ssl.SSLHandshake.consume(SSLHandshake.java:396)
        at java.base/sun.security.ssl.HandshakeContext.dispatch(HandshakeContext.java:480)
        at java.base/sun.security.ssl.HandshakeContext.dispatch(HandshakeContext.java:458)
        at java.base/sun.security.ssl.TransportContext.dispatch(TransportContext.java:200)
        at java.base/sun.security.ssl.SSLTransport.decode(SSLTransport.java:172)
        at java.base/sun.security.ssl.SSLSocketImpl.decode(SSLSocketImpl.java:1500)
        at java.base/sun.security.ssl.SSLSocketImpl.readHandshakeRecord(SSLSocketImpl.java:1415)
        at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:450)
        at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:421)
        at java.base/sun.net.www.protocol.https.HttpsClient.afterConnect(HttpsClient.java:580)
        at java.base/sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:183)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1665)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1589)
        at java.base/sun.net.www.protocol.https.HttpsURLConnectionImpl.getInputStream(HttpsURLConnectionImpl.java:224)
        at com.sup.dev.java_pc.google.GoogleAuth.requestByIdToken(GoogleAuth.kt:66)
        at com.sup.dev.java_pc.google.GoogleAuth.getGoogleId(GoogleAuth.kt:30)
        at com.dzen.campfire.server.app.AccountProviderImpl.getByLoginToken(AccountProviderImpl.kt:55)
        at com.dzen.campfire.api.tools.server.AccountProvider.loginByLogin(AccountProvider.kt:52)
        at com.dzen.campfire.api.tools.server.AccountProvider.getAccount(AccountProvider.kt:16)
        at com.dzen.campfire.api.tools.server.ApiServer.parseConnection(ApiServer.kt:200)
        at com.dzen.campfire.api.tools.server.ApiServer.parseConnectionHttp(ApiServer.kt:102)
        at com.dzen.campfire.api.tools.server.ApiServer.access$parseConnectionHttp(ApiServer.kt:17)
        at com.dzen.campfire.api.tools.server.ApiServer$startServerHTTPS$server$1$1.run(ApiServer.kt:59)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:539)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
        at java.base/sun.security.validator.PKIXValidator.doBuild(PKIXValidator.java:439)
        at java.base/sun.security.validator.PKIXValidator.engineValidate(PKIXValidator.java:306)
        at java.base/sun.security.validator.Validator.validate(Validator.java:264)
        at java.base/sun.security.ssl.X509TrustManagerImpl.checkTrusted(X509TrustManagerImpl.java:231)
        at java.base/sun.security.ssl.X509TrustManagerImpl.checkServerTrusted(X509TrustManagerImpl.java:132)
        at java.base/sun.security.ssl.CertificateMessage$T13CertificateConsumer.checkServerCerts(CertificateMessage.java:1341)
        ... 30 more
Caused by: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
        at java.base/sun.security.provider.certpath.SunCertPathBuilder.build(SunCertPathBuilder.java:141)
        at java.base/sun.security.provider.certpath.SunCertPathBuilder.engineBuild(SunCertPathBuilder.java:126)
        at java.base/java.security.cert.CertPathBuilder.build(CertPathBuilder.java:297)
        at java.base/sun.security.validator.PKIXValidator.doBuild(PKIXValidator.java:434)
        ... 35 more
DEE, javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
DII, Google ID is null
XInfo, DII, [Campfire] null [185.113.38.239] EPostGet 0 ms runtime[0%]



 */