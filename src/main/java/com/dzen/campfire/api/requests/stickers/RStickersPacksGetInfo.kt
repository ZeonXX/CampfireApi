package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.models.publications.stickers.PublicationStickersPack
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersPacksGetInfo(
        var packId: Long,
        var stickerId: Long
) : Request<RStickersPacksGetInfo.Response>() {


    override fun jsonSub(inp: Boolean, json: Json) {
        packId = json.m(inp, "packId", packId)
        stickerId = json.m(inp, "stickerId", stickerId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var stickersPack = PublicationStickersPack()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(stickersPack:PublicationStickersPack) {
            this.stickersPack = stickersPack
        }

        override fun json(inp: Boolean, json: Json) {
            stickersPack = json.m(inp, "stickersPack", stickersPack)
        }

    }

}
