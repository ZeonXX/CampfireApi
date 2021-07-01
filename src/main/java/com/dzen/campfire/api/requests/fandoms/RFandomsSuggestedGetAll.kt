package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.fandoms.Fandom
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RFandomsSuggestedGetAll(var offset: Long) : Request<RFandomsSuggestedGetAll.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var fandoms: Array<Fandom> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(fandoms: Array<Fandom>) {
            this.fandoms = fandoms
        }

        override fun json(inp: Boolean, json: Json) {
            fandoms = json.m(inp, "fandoms", fandoms, Array<Fandom>::class)
        }

    }

    companion object {

        val COUNT = 20
    }


}