package com.dzen.campfire.api.requests.translates

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTranslateChange(
        var languageId: Long,
        var languageIdFrom: Long,
        var key:String,
        var text:String,
        var comment:String
) : Request<RTranslateChange.Response>() {


    override fun jsonSub(inp: Boolean, json: Json) {
        languageId = json.m(inp, "languageId", languageId)
        languageIdFrom = json.m(inp, "languageIdFrom", languageIdFrom)
        key = json.m(inp, "key", key)
        text = json.m(inp, "text", text)
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