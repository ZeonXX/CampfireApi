package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostChangeFandom(
        var publicationId: Long,
        var fandomId: Long,
        var languageId: Long,
        var comment: String
) : Request<RPostChangeFandom.Response>() {

    companion object{
        val E_SAME_FANDOM = "E_SAME_FANDOM"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
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