package com.dzen.campfire.api.requests.tags

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTagsCreate(
        var name: String,
        var comment: String,
        var fandomId: Long,
        var languageId: Long,
        var parentId: Long,
        var image:ByteArray?
) : Request<RTagsCreate.Response>() {

    companion object {
        val E_PARENT_DONT_EXIST = "E_PARENT_DONT_EXIST"
        val E_PARENT_BAD_TYPE = "E_PARENT_BAD_TYPE"
        val E_BAD_IMAGE_WEIGHT = "E_BAD_IMAGE_WEIGHT"
        val E_BAD_IMAGE_SIZE = "E_BAD_IMAGE_SIZE"
        val E_BAD_NAME_SIZE = "E_BAD_NAME_SIZE"
    }

    init {

        addDataOutput(image)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        name = json.m(inp, "name", name)
        comment = json.m(inp, "comment", comment)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        parentId = json.m(inp, "parentId", parentId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publicationId: Long = 0

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publicationId: Long) {
            this.publicationId = publicationId
        }

        override fun json(inp: Boolean, json: Json) {
            publicationId = json.m(inp, "unitId", publicationId)
        }

    }



}