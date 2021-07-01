package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersPackChangeAvatar(
        var packId: Long,
        var avatar: ByteArray?
) : Request<RStickersPackChangeAvatar.Response>() {

    init {
        addDataOutput(avatar)
    }

    override fun updateDataOutput() {
        avatar = dataOutput[0]
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        packId = json.m(inp, "packId", packId)
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