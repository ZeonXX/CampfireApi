package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RAccountsFollowsGetAll(
        var followsOfaAccountId: Long,
        var offset: Long,
        var followers:Boolean
) : Request<RAccountsFollowsGetAll.Response>() {

    companion object {

        val COUNT = 20
    }


    init {
        cashAvailable = false
    }


    override fun jsonSub(inp: Boolean, json: Json) {
        followsOfaAccountId = json.m(inp, "followsOfaAccountId", followsOfaAccountId)
        offset = json.m(inp, "offset", offset)
        followers = json.m(inp, "followers", followers)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var accounts: Array<Account> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(accounts: Array<Account>) {
            this.accounts = accounts
        }

        override fun json(inp: Boolean, json: Json) {
            accounts = json.m(inp, "accounts", accounts, Array<Account>::class)
        }

    }

}
