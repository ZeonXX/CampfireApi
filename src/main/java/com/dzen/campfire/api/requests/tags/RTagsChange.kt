package com.dzen.campfire.api.requests.tags

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTagsChange(
        var publicationId: Long,
        var name: String?,
        var comment: String,
        var image:ByteArray?,
        var removeImage: Boolean
) : Request<RTagsChange.Response>() {

    companion object {
        val E_BAD_TYPE = "E_BAD_TYPE"
        val E_BAD_IMAGE_WEIGHT = "E_BAD_IMAGE_WEIGHT"
        val E_BAD_IMAGE_SIZE = "E_BAD_IMAGE_SIZE"
        val E_BAD_PARAMS = "E_BAD_PARAMS"
        val E_BAD_NAME_SIZE = "E_BAD_NAME_SIZE"
    }

    init {

        addDataOutput(image)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        name = json.mNull(inp, "name", name, String::class)
        comment = json.m(inp, "comment", comment)
        removeImage = json.m(inp, "removeImage", removeImage)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        constructor(json: Json) {
            json(false, json)
        }

        constructor() {

        }

        override fun json(inp: Boolean, json: Json) {

        }

    }

}