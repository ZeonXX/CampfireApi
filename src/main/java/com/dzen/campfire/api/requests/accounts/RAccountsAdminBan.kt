package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsAdminBan(
        var accountId: Long,
        var banTime: Long,
        var comment: String
) : Request<RAccountsAdminBan.Response>() {

    companion object {
        val E_LOW_KARMA_FORCE = "E_LOW_KARMA_FORCE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        banTime = json.m(inp, "banTime", banTime)
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
