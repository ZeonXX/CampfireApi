package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.MAccountEffect
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsAdminEffectAdd(
        var accountId: Long,
        var effectIndex: Long,
        var effectEndDate: Long,
        var comment: String
) : Request<RAccountsAdminEffectAdd.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        effectIndex = json.m(inp, "effectIndex", effectIndex)
        effectEndDate = json.m(inp, "effectEndDate", effectEndDate)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }


    class Response : Request.Response {

        constructor(json: Json) {
            json(false, json)
        }

        constructor() {

        }

        override fun json(inp: Boolean, json: Json) {

        }

    }

}
