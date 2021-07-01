package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.AccountReports
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsReportsGetAll(
        var offset: Long
) : Request<RAccountsReportsGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var accounts: Array<AccountReports> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(accounts: Array<AccountReports>) {
            this.accounts = accounts
        }

        override fun json(inp: Boolean, json: Json) {
            accounts = json.m(inp, "accounts", accounts, Array<AccountReports>::class)
        }

    }

}