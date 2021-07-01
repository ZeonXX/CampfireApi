package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RPublicationsReport(
        var publicationId: Long,
        var comment:String
) : Request<RPublicationsReport.Response>() {

    companion object {
        val E_ALREADY_EXIST = "E_ALREADY_EXIST"
        val E_BAD_TYPE = "E_BAD_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

}