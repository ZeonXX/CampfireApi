package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectStatisticErrorsRemove(
        var key: String
) : Request<RProjectStatisticErrorsRemove.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        key = json.m(inp, "key", key)
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