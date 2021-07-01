package com.dzen.campfire.api.requests.tags

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RTagsRemove(
        var comment: String,
        var publicationId: Long
) : Request<RTagsRemove.Response>() {

    companion object {
        val E_BAD_TYPE = "E_BAD_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        comment = json.m(inp, "comment", comment)
        publicationId = json.m(inp, "unitId", publicationId)
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