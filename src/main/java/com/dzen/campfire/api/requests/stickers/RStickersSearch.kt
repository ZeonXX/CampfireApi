package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.models.publications.stickers.PublicationStickersPack
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersSearch(
        var offset: Long
) : Request<RStickersSearch.Response>() {

    companion object {
        val COUNT = 20
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var stickersPacks: Array<PublicationStickersPack> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(stickersPacks: Array<PublicationStickersPack>) {
            this.stickersPacks = stickersPacks
        }

        override fun json(inp: Boolean, json: Json) {
            stickersPacks = json.m(inp, "stickersPacks", stickersPacks, Array<PublicationStickersPack>::class)
        }

    }

}
