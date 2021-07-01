package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.models.publications.stickers.PublicationSticker
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersGetAllByPackId(
        var packId:Long
) : Request<RStickersGetAllByPackId.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        packId = json.m(inp, "packId", packId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var stickers: Array<PublicationSticker> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(stickers: Array<PublicationSticker>) {
            this.stickers = stickers
        }

        override fun json(inp: Boolean, json: Json) {
            stickers = json.m(inp, "stickers", stickers, Array<PublicationSticker>::class)
        }

    }

}
