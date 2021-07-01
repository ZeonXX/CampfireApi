package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickerCollectionRemove(
        var stickerId: Long
) : Request<RStickerCollectionRemove.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        stickerId = json.m(inp, "stickerId", stickerId)
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
