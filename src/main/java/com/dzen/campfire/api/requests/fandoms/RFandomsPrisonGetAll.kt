package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.account.AccountPrison
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsPrisonGetAll(
        var fandomId:Long,
        var languageId:Long,
        var offset:Long
) : Request<RFandomsPrisonGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
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
