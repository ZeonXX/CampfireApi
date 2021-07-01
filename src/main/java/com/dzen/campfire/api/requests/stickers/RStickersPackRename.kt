package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersPackRename(
        var packId: Long,
        var packName: String
) : Request<RStickersPackRename.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        packId = json.m(inp, "packId", packId)
        packName = json.m(inp, "packName", packName)
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