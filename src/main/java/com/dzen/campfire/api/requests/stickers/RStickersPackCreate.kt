package com.dzen.campfire.api.requests.stickers

import com.dzen.campfire.api.models.publications.stickers.PublicationStickersPack
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RStickersPackCreate(
        var packName: String,
        var avatar: ByteArray?
) : Request<RStickersPackCreate.Response>() {

    companion object{

        val E_BAD_IMAGE_WEIGHT = "E_BAD_IMAGE_WEIGHT"
        val E_BAD_IMAGE_SIZE = "E_BAD_IMAGE_SIZE"
        val E_BAD_NAME_SIZE = "E_BAD_NAME_SIZE"
        val E_BAD_NAME = "E_BAD_NAME"
        val E_TOO_MANY = "E_TOO_MANY"

    }

    init {
        addDataOutput(avatar)
    }

    override fun updateDataOutput() {
        avatar = dataOutput[0]
    }

    override fun jsonSub(inp: Boolean, json: Json) {
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