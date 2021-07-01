package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RPublicationsAdminClearReports(var publicationId: Long) : Request<RPublicationsAdminClearReports.Response>() {

    companion object {
        val E_SELF = "E_SELF"
    }

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
