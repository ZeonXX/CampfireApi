package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersPackCollectionRemove(
        var stickersPackId: Long
) : Request<RStickersPackCollectionRemove.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        stickersPackId = json.m(inp, "stickersPackId", stickersPackId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        constructor(json: Json) {
            json(false, json)
        }

        constructor() {
        }

        override fun json(inp: Boolean, json: Json) {
        }

    }

}
