package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationToDrafts(
        var publicationId: Long,
        var comment:String
) : Request<RFandomsModerationToDrafts.Response>() {

    companion object {
        val E_ALREADY = "E_ALREADY"
        val E_BLOCKED = "E_BLOCKED"
        val E_BAD_TYPE = "E_BAD_TYPE"
        val E_LOW_KARMA_FORCE = "E_LOW_KARMA_FORCE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        constructor(json: Json) {
            json(false, json)
        }

        constructor()

        override fun json(inp: Boolean, json: Json) {

        }

    }

}