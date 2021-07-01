package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationImportant(
        var publicationId: Long,
        var important: Boolean,
        var comment:String
) : Request<RFandomsModerationImportant.Response>() {

    companion object {
        val E_BAD_TYPE = "E_BAD_TYPE"
    }


    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        important = json.m(inp, "important", important)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

}