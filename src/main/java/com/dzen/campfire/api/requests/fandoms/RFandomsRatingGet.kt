package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsRatingGet(
        var fandomId: Long,
        var languageId: Long,
        var offset: Long
) : Request<RFandomsRatingGet.Response>() {

    companion object {
        val COUNT = 25
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

        var karmaAccounts: Array<Account> = emptyArray()
        var karmaCounts: Array<Long> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(karmaAccounts: Array<Account>, karmaCounts: Array<Long>) {
            this.karmaAccounts = karmaAccounts
            this.karmaCounts = karmaCounts
        }

        override fun json(inp: Boolean, json: Json) {
            karmaAccounts = json.m(inp, "karmaAccounts", karmaAccounts, Array<Account>::class)
            karmaCounts = json.m(inp, "karmaCounts", karmaCounts, Array<Long>::class)
        }
    }

}