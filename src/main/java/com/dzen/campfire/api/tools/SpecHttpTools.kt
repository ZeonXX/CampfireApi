package com.dzen.campfire.api.tools

import com.sup.dev.java.libs.debug.err
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object SpecHttpTools {



    fun disableCertVerification() {
        var ctx: SSLContext? = null
        try {
            ctx = SSLContext.getInstance("TLS")
        } catch (e: NoSuchAlgorithmException) {
            err(e)
        }

        try {
            ctx!!.init(null, arrayOf<TrustManager>(object : X509TrustManager {
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}

                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            }), null)
        } catch (e: KeyManagementException) {
            err(e)
        }

        HttpsURLConnection.setDefaultSSLSocketFactory(ctx!!.socketFactory)
        HttpsURLConnection.setDefaultHostnameVerifier { _, _ -> true }
    }


}