package com.dzen.campfire.api.requests.tags

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTagsMoveTag(
        var publicationId: Long,
        var beforeTagId: Long,
        var comment: String
) : Request<RTagsMoveTag.Response>() {

    companion object {

        val E_BAD_TYPE = "E_BAD_TYPE"
        val E_BAD_TAG = "E_BAD_TAG"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        beforeTagId = json.m(inp, "beforeTagId", beforeTagId)
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