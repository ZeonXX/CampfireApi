package com.dzen.campfire.api.requests.achievements

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAchievementsInfo(
        var accountId: Long
) : Request<RAchievementsInfo.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var karma30 = 0L
        var karmaForce = 0L
        var indexes:Array<Long> = emptyArray()
        var lvls:Array<Long> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(karma30: Long,
                    karmaForce: Long,
                    indexes:Array<Long>,
                    lvls:Array<Long>) {
            this.karma30 = karma30
            this.karmaForce = karmaForce
            this.indexes = indexes
            this.lvls = lvls
        }

        override fun json(inp: Boolean, json: Json) {
            karma30 = json.m(inp, "karma30", karma30)
            karmaForce = json.m(inp, "karmaForce", karmaForce)
            indexes = json.m(inp, "indexes", indexes)
            lvls = json.m(inp, "lvls", lvls)
        }

    }


}