package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.models.publications.stickers.PublicationSticker
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersAdd(
        var packId: Long,
        var image: ByteArray?,
        var gif: ByteArray?
) : Request<RStickersAdd.Response>() {

    companion object {
        val E_BAD_IMG_WEIGHT = "E_BAD_IMG_WEIGHT"
        val E_BAD_IMG_SIDES = "E_BAD_IMG_SIDES"
        val E_BAD_CREATOR_ID = "E_BAD_CREATOR_ID"
        val E_BAD_PARENT_PUBLICATION_TYPE = "E_BAD_PARENT_PUBLICATION_TYPE"
        val E_BAD_STICKERS_COUNT = "E_BAD_STICKERS_COUNT"
    }

    init {
        addDataOutput(image)
        addDataOutput(gif)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
        gif = dataOutput[1]
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        packId = json.m(inp, "packId", packId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var sticker = PublicationSticker()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(sticker: PublicationSticker) {
            this.sticker = sticker
        }

        override fun json(inp: Boolean, json: Json) {
            sticker = json.m(inp, "sticker", sticker)
        }

    }

}