package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsFirebaseAdd(
    var fbToken: String
) : Request<RAccountsFirebaseAdd.Response>() {
    companion object {
        const val E_VERIFY = "E_VERIFY"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fbToken = json.m(inp, "fbToken", fbToken)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response()
}