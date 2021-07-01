package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationLinkRemove(
        var linkIndex: Long,
        var comment: String
) : Request<RFandomsModerationLinkRemove.Response>() {

    companion object {
        val E_BAD_TYPE = "E_BAD_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        linkIndex = json.m(inp, "linkIndex", linkIndex)
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