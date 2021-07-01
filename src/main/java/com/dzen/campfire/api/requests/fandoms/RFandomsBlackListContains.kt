package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsBlackListContains(
        var fandomId: Long
) : Request<RFandomsBlackListContains.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {


        var contains = false

        constructor(json: Json) {
            json(false, json)
        }

        constructor(contains: Boolean) {
            this.contains = contains
        }

        override fun json(inp: Boolean, json: Json) {
            contains = json.m(inp, "contains", contains)
        }


    }


}
