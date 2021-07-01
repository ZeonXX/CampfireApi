package com.dzen.campfire.api.requests.translates

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTranslateReject(
        var historyId: Long,
        var comment:String
) : Request<RTranslateReject.Response>() {

    companion object{
        val ERROR_ALREADY_ACCEPTED = "ERROR_ALREADY_ACCEPTED"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        historyId = json.m(inp, "languageId", historyId)
        comment = json.m(inp, "comment", comment)
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