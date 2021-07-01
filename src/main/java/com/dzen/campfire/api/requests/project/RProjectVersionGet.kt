package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectVersionGet : Request<RProjectVersionGet.Response>() {

    init {
        tokenRequired = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {

    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var version = ""
        var ABParams = Json()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(version: String, ABParams: Json) {
            this.version = version
            this.ABParams = ABParams
        }

        override fun json(inp: Boolean, json: Json) {
            version = json.m(inp, "version", version)
            ABParams = json.m(inp, "ABParams", ABParams)
        }

    }

}