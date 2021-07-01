package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectKeyGet(
        var key: String
) : Request<RProjectKeyGet.Response>() {

    init {
        tokenRequired = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        key = json.m(inp, "key", key)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var value = ""

        constructor(json: Json) {
            json(false, json)
        }

        constructor(value: String) {
            this.value = value
        }

        override fun json(inp: Boolean, json: Json) {
            value = json.m(inp, "value", value)
        }

    }

}