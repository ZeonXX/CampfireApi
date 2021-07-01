package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsStatusSet(var status: String) : Request<RAccountsStatusSet.Response>() {

    companion object {
        val E_BAD_SIZE = "E_BAD_SIZE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        status = json.m(inp, "status", status)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

}
