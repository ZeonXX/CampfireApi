package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.AccountPunishment
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsPunishmentsGetAll(
        var accountId:Long,
        var offset:Long
) : Request<RAccountsPunishmentsGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var punishments: Array<AccountPunishment> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(punishments: Array<AccountPunishment>) {
            this.punishments = punishments
        }

        override fun json(inp: Boolean, json: Json) {
            punishments = json.m(inp, "punishments", punishments, Array<AccountPunishment>::class)
        }

    }


}
