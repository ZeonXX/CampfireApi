package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RPublicationsOnShare(var publicationId: Long) : Request<RPublicationsOnShare.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }


}