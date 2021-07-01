package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationChangeImageTitle(
        var fandomId: Long,
        var languageId: Long,
        var image: ByteArray?,
        var imageGif: ByteArray?,
        var comment: String
) : Request<RFandomsModerationChangeImageTitle.Response>() {

    companion object {
        val E_BAD_IMG_WEIGHT = "E_BAD_IMG_WEIGHT"
        val E_BAD_IMG_SIDES = "E_BAD_IMG_SIDES"
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
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        comment = json.m(inp, "comment", comment)
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