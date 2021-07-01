package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationDescriptionChange(
        var fandomId: Long,
        var languageId: Long,
        var description: String,
        var comment: String
) : Request<RFandomsModerationDescriptionChange.Response>() {

    companion object {
        val E_BAD_TEXT_LENGTH = "E_BAD_TEXT_LENGTH"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        description = json.m(inp, "description", description)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        constructor(json:Json){
            json(false, json)
        }

        constructor(){

        }

        override fun json(inp: Boolean, json: Json) {
        }

    }


}