package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPublicationsReactionGetAccounts(
        var publicationId: Long,
        var reactionIndex: Long
) : Request<RPublicationsReactionGetAccounts.Response>() {

    companion object {
    }

    init {

    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        reactionIndex = json.m(inp, "reactionIndex", reactionIndex)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var accounts = emptyArray<Account>()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(accounts:Array<Account>) {
            this.accounts=  accounts
        }

        override fun json(inp: Boolean, json: Json) {
            accounts = json.m(inp, "accounts", accounts)
        }

    }

}