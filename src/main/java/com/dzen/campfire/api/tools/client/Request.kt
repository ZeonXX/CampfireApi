package com.dzen.campfire.api.tools.client

import com.dzen.campfire.api.tools.ApiAccount
import com.dzen.campfire.api.tools.ApiException
import com.sup.dev.java.classes.callbacks.CallbacksList
import com.dzen.campfire.api.tools.server.ApiRequest
import com.sup.dev.java.classes.Subscription
import com.sup.dev.java.classes.callbacks.CallbacksList1
import com.sup.dev.java.libs.json.Json
import java.util.HashMap

@ApiRequest
abstract class Request<K : Request.Response> : Subscription(){

    var dateCreated = 0L
    var requestApiVersion = ""
    var requestProjectKey = ""
    var cashAvailable = false
    var tokenRequired = true
    var tokenDesirable = false
    var requestType = ApiClient.REQUEST_TYPE_REQUEST

    //
    //  Debug
    //

    var noErrorLogs = false

    //
    //  Data Output
    //

    var dataOutput = arrayOfNulls<ByteArray>(0)
    var dataOutputBase64 = arrayOfNulls<String>(0)

    //
    //  Server part
    //

    var apiAccount: ApiAccount = ApiAccount()
    var accessToken: String? = null
    var refreshToken: String? = null
    var loginToken: String? = null
    var botToken: String? = null

    //
    //  Subscription
    //

    var onCompleteList = CallbacksList1<K>()
    var onNetworkErrorList= CallbacksList()
    var onApiErrorList = CallbacksList1<ApiException>()
    var onErrorList = CallbacksList1<Exception>()
    var onCompleteUnsubscribedList = CallbacksList1<K>()
    var onFinishList = CallbacksList()
    var onApiErrors: HashMap<String, (ApiException) -> Unit> = HashMap()

    init {
        this.dateCreated = System.nanoTime()
    }

    protected abstract fun jsonSub(inp: Boolean, json: Json)

    open fun instanceResponse(json: Json): K {
        throw RuntimeException("Not implemented [" + this::class + "]")
    }

    open fun instanceResponse(data: ByteArray): K {
        throw RuntimeException("Not implemented [" + this::class + "]")
    }

    fun setAccessToken(accessToken:String):Request<K>{
        this.accessToken = accessToken
        return this
    }

    fun setLoginToken(loginToken:String):Request<K>{
        this.loginToken = loginToken
        return this
    }

    fun addDataOutput(bytes: ByteArray?):Int {
        val dataOutputNew = arrayOfNulls<ByteArray>(dataOutput.size + 1)
        for (i in dataOutput.indices) dataOutputNew[i] = dataOutput[i]
        val index = dataOutputNew.size - 1
        dataOutputNew[index] = bytes
        dataOutput = dataOutputNew
        return index
    }

    private fun jsonDataOutput(inp: Boolean, json: Json) {

        if (inp) {
            val a = Array(dataOutput.size) { 0 }
            for (i in dataOutput.indices) a[i] = if (dataOutput[i] == null) -1 else dataOutput[i]!!.size

            json.put("dataOutput", a)
        } else {
            val a = json.getInts("dataOutput")
            if (a != null) {
                dataOutput = arrayOfNulls(a.size)
                for (i in a.indices) dataOutput[i] = if (a[i] == -1) null else ByteArray(a[i]) { 0 }
            }
        }
    }

    open fun updateDataOutput() {

    }

    //
    //  To Json
    //

    fun json(inp: Boolean, json: Json) {
        this.dateCreated = json.m(inp, "J_REQUEST_DATE", dateCreated)
        this.requestApiVersion = json.m(inp, "requestApiVersion", requestApiVersion)
        this.requestProjectKey = json.m(inp, "requestProjectKey", requestProjectKey)
        this.dataOutputBase64 = json.m(inp, "dataOutputBase64", dataOutputBase64)
        jsonDataOutput(inp, json)
        if (inp) {
            json.put(J_REQUEST_NAME, javaClass.simpleName)
        }
        jsonSub(inp, json)
    }

    //
    //  Response
    //

    abstract class Response {

        open fun json(inp: Boolean, json: Json) {

        }

        open fun getData(): ByteArray? {
            return null
        }
    }

    @Throws(ApiException::class)
    open fun check() {

    }

    @Throws(ApiException::class)
    open fun execute(): K {
        throw RuntimeException("You must override this method")
    }

    fun onComplete(onComplete: (K) -> Unit): Request<K> {
        this.onCompleteList.add(onComplete)
        return this
    }

    fun onCompleteUnsubscribed(onCompleteUnsubscribed: (K) -> Unit): Request<K> {
        this.onCompleteUnsubscribedList.add(onCompleteUnsubscribed)
        return this
    }

    fun onApiError(onApiError: (ApiException) -> Unit): Request<K> {
        this.onApiErrorList.add(onApiError)
        return this
    }

    fun onApiError(code: String, onApiError: (ApiException) -> Unit): Request<K> {
        onApiErrors[code] = onApiError
        return this
    }

    fun onNetworkError(onNetworkError: () -> Unit): Request<K> {
        this.onNetworkErrorList.add(onNetworkError)
        return this
    }

    fun onFinish(onFinish: () -> Unit): Request<K> {
        this.onFinishList.add(onFinish)
        return this
    }

    fun onError(onError: (Exception) -> Unit): Request<K> {
        onErrorList.add(onError)
        return this
    }

    fun send(apiClient: ApiClient): Request<K> {
        requestApiVersion = apiClient.getApiVersion()
        requestProjectKey = apiClient.projectKey
        apiClient.sendRequest(this)
        return this
    }

    fun sendNow(apiClient: ApiClient): Request<K> {
        requestApiVersion = apiClient.getApiVersion()
        requestProjectKey = apiClient.projectKey
        apiClient.sendRequestNow(this)
        return this
    }

    companion object {

        //
        //  Client Part
        //

        val J_REQUEST_NAME = "J_REQUEST_NAME"
    }


}
