package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPublicationsAdminRestore(
        var moderationId: Long,
        var comment: String,
        var vahter: Boolean,
) : Request<RPublicationsAdminRestore.Response>() {

    companion object {
        val E_SELF = "E_SELF"
        val E_BAD_STATUS = "E_BAD_STATUS"
        val E_BAD_MODERATION_TYPE = "E_BAD_MODERATION_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        moderationId = json.m(inp, "moderationId", moderationId)
        comment = json.m(inp, "comment", comment)
        vahter = json.m(inp, "vahter", vahter)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }


}
