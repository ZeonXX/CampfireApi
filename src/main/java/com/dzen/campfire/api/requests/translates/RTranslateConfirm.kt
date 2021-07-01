package com.dzen.campfire.api.requests.translates

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTranslateConfirm(
        var historyId: Long
) : Request<RTranslateConfirm.Response>() {


    override fun jsonSub(inp: Boolean, json: Json) {
        historyId = json.m(inp, "historyId", historyId)
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