package com.dzen.campfire.api.requests.project


import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectGetEffect(
        var effectId: Long
) : Request<RProjectGetEffect.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        effectId = json.m(inp, "effectId", effectId)
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