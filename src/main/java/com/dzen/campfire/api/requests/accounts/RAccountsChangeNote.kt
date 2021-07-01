package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsChangeNote(
        var accountId:Long,
        var note: String
) : Request<RAccountsChangeNote.Response>() {

    companion object {
        val E_TOO_LONG = "E_TOO_LONG"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        note = json.m(inp, "note", note)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

}