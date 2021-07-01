package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.models.publications.stickers.PublicationStickersPack
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersPacksGetAllByAccount(
        var accountId: Long,
        var offsetDate: Long,
        var count: Int = 20
) : Request<RStickersPacksGetAllByAccount.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        offsetDate = json.m(inp, "offsetDate", offsetDate)
        count = json.m(inp, "count", count)
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
