package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsGetAllOnline(
        var offsetDate: Long
) : Request<RAccountsGetAllOnline.Response>() {

    companion object {
        val COUNT = 50
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offsetDate = json.m(inp, "offsetDate", offsetDate)
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