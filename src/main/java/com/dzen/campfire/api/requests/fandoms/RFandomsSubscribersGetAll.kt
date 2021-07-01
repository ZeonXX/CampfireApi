package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RFandomsSubscribersGetAll(
        var offset:Long,
        var fandomId:Long,
        var languageId:Long
) : Request<RFandomsSubscribersGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
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