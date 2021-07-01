package com.dzen.campfire.api.tools.client

interface TokenProvider {

    fun getToken(callbackSource: (String?) -> Unit)

    fun clearToken()

    fun onLoginFailed()

}