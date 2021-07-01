package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationNames(
        var fandomId: Long,
        var languageId: Long,
        var names: Array<String>,
        var comment:String
) : Request<RFandomsModerationNames.Response>() {

    companion object {
        val E_TOO_MANY_ITEMS = "E_TOO_MANY_ITEMS"
        val E_BAD_SIZE = "E_BAD_SIZE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        names = json.m(inp, "names", names)
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