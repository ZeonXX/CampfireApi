package com.dzen.campfire.api.requests.achievements

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAchievementsPack(
        var accountId: Long,
        var packIndex: Int
) : Request<RAchievementsPack.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        packIndex = json.m(inp, "packIndex", packIndex)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var indexes:Array<Long> = emptyArray()
        var progress:Array<Long> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(
                    indexes:Array<Long>,
                    progress:Array<Long>) {
            this.indexes = indexes
            this.progress = progress
        }

        override fun json(inp: Boolean, json: Json) {
            indexes = json.m(inp, "indexes", indexes)
            progress = json.m(inp, "progress", progress)
        }

    }


}