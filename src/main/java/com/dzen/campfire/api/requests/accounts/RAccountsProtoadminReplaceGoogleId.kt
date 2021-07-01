package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsProtoadminReplaceGoogleId(
        var accountId: Long,
        var targetAccountId: Long
) : Request<RAccountsProtoadminReplaceGoogleId.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        targetAccountId = json.m(inp, "targetAccountId", targetAccountId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }


}
