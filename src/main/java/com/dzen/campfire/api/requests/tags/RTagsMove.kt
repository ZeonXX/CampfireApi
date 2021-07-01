package com.dzen.campfire.api.requests.tags

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTagsMove(
        var publicationId: Long,
        var newCategoryId: Long,
        var comment: String
) : Request<RTagsMove.Response>() {

    companion object {

        val E_BAD_TYPE = "E_BAD_TYPE"
        val E_BAD_CATEGORY = "E_BAD_CATEGORY"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        newCategoryId = json.m(inp, "newCategoryId", newCategoryId)
        comment = json.m(inp, "comment", comment)
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