package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsBlackListGetAll(
        var accountId: Long,
        var offset: Long
) : Request<RAccountsBlackListGetAll.Response>() {

    companion object {
        val COUNT = 20L
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        offset = json.m(inp, "offset", offset)
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
