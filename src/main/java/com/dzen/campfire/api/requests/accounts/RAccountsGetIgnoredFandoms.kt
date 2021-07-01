package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsGetIgnoredFandoms(
        var accountId: Long
) : Request<RAccountsGetIgnoredFandoms.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var fandomsIds: Array<Long> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(fandomsIds: Array<Long>) {
            this.fandomsIds = fandomsIds
        }

        override fun json(inp: Boolean, json: Json) {
            fandomsIds = json.m(inp, "fandomsIds", fandomsIds)
        }

    }

}