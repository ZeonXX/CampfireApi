package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsPunishmentsGetInfo(
        var accountId:Long
) : Request<RAccountsPunishmentsGetInfo.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var bansCount = 0L
        var warnsCount = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(bansCount:Long, warnsCount:Long) {
            this.bansCount = bansCount
            this.warnsCount = warnsCount
        }

        override fun json(inp: Boolean, json: Json) {
            bansCount = json.m(inp, "bansCount", bansCount)
            warnsCount = json.m(inp, "warnsCount", warnsCount)
        }

    }


}
