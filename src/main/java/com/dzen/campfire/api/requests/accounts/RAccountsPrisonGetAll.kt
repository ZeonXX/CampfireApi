package com.dzen.campfire.api.requests.accounts


import com.dzen.campfire.api.models.account.AccountPrison
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsPrisonGetAll(
        var offset:Long
) : Request<RAccountsPrisonGetAll.Response>() {

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

        var accounts: Array<AccountPrison> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(accounts: Array<AccountPrison>) {
            this.accounts = accounts
        }

        override fun json(inp: Boolean, json: Json) {
            accounts = json.m(inp, "accounts", accounts, Array<AccountPrison>::class)
        }

    }


}
