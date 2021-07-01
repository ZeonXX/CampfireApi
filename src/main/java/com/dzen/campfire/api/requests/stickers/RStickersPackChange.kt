package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.models.publications.stickers.PublicationStickersPack
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersPackChange(
        var publicationId:Long,
        var packName: String,
        var avatar: ByteArray?
) : Request<RStickersPackChange.Response>() {

    companion object{

        val E_BAD_IMAGE_WEIGHT = "E_BAD_IMAGE_WEIGHT"
        val E_BAD_IMAGE_SIZE = "E_BAD_IMAGE_SIZE"
        val E_BAD_NAME_SIZE = "E_BAD_NAME_SIZE"
        val E_BAD_NAME = "E_BAD_NAME"

    }

    init {
        addDataOutput(avatar)
    }

    override fun updateDataOutput() {
        avatar = dataOutput[0]
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        packName = json.m(inp, "packName", packName)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var stickersPack = PublicationStickersPack()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(stickersPack: PublicationStickersPack) {
            this.stickersPack = stickersPack
        }

        override fun json(inp: Boolean, json: Json) {
            stickersPack = json.m(inp, "stickersPack", stickersPack)
        }

    }

}