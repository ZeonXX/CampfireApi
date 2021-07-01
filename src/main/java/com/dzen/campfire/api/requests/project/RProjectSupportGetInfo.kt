package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectSupportGetInfo : Request<RProjectSupportGetInfo.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {

    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var totalCount = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(totalCount: Long) {
            this.totalCount = totalCount
        }

        override fun json(inp: Boolean, json: Json) {
            totalCount = json.m(inp, "totalCount", totalCount)
        }

    }

}