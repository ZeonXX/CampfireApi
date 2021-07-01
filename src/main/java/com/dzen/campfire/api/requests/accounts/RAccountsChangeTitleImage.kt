package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RAccountsChangeTitleImage(
        var image: ByteArray?,
        var imageGif: ByteArray?
) : Request<RAccountsChangeTitleImage.Response>() {

    companion object {
        val E_BAD_IMG = "E_BAD_IMG"
        val E_BAD_IMG_SIDES = "E_BAD_IMG_SIDES"
        val E_BAD_IMG_WEIGHT = "E_BAD_IMG_WEIGHT"
    }

    init {
        addDataOutput(image)
        addDataOutput(imageGif)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
        imageGif = dataOutput[1]
    }

    override fun jsonSub(inp: Boolean, json: Json) {

    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var imageId = 0L
        var imageGifId = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(imageId: Long, imageGifId: Long) {
            this.imageId = imageId
            this.imageGifId = imageGifId
        }

        override fun json(inp: Boolean, json: Json) {
            imageId = json.m(inp, "imageId", imageId)
            imageGifId = json.m(inp, "imageGifId", imageGifId)
        }

    }

}