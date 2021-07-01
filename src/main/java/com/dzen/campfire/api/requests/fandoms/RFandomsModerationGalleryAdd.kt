package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationGalleryAdd(
        var fandomId: Long,
        var languageId: Long,
        var image: ByteArray?,
        var comment: String
) : Request<RFandomsModerationGalleryAdd.Response>() {

    companion object {
        val E_TOO_MANY_ITEMS = "E_TOO_MANY_ITEMS"
        val E_BAD_IMAGE = "E_BAD_IMAGE"
    }

    init {
        addDataOutput(image)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
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

        constructor(json: Json) {
            json(false, json)
        }

        constructor(imageId: Long) {
            this.imageId = imageId
        }

        override fun json(inp: Boolean, json: Json) {
            imageId = json.m(inp, "imageId", imageId)
        }

    }


}