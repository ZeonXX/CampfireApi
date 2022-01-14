package com.dzen.campfire.api.requests.rubrics

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RRubricsMoveFandom(
    var rubricId: Long,
    var fandomId: Long,
    var languageId: Long,
    var moderatorComment: String,
) : Request<RRubricsMoveFandom.Response>() {
    companion object {
        const val E_SAME_FANDOM = "E_SAME_FANDOM"
        const val E_BAD_COMMENT = "E_BAD_COMMENT"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        rubricId = json.m(inp, "rubricId", rubricId)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        moderatorComment = json.m(inp, "moderatorComment", moderatorComment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        constructor()

        constructor(json: Json) {
            json(false, json)
        }

        override fun json(inp: Boolean, json: Json) {
            super.json(inp, json)
        }
    }
}