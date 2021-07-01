package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPublicationsAdminRemove(var moderationId: Long) : Request<RPublicationsAdminRemove.Response>() {

    companion object {
        val E_SELF = "E_SELF"
        val E_BAD_PUBLICATION_TYPE = "E_BAD_PUBLICATION_TYPE"
        val E_BAD_MODERATION_TYPE = "E_BAD_MODERATION_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        moderationId = json.m(inp, "moderationId", moderationId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }


}
