package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsAdminChangeName(var accountId: Long, var name: String, var comment: String) : Request<RAccountsAdminChangeName.Response>() {

    companion object {
        val E_LOGIN_CHARS = "E_LOGIN_CHARS"
        val E_LOGIN_LENGTH = "E_LOGIN_LENGTH"
        val E_LOGIN_NOT_ENABLED = "E_LOGIN_NOT_ENABLED"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        name = json.m(inp, "name", name)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }


}
