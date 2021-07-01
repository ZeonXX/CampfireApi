package com.dzen.campfire.api.requests.rubrics

import com.dzen.campfire.api.models.fandoms.Rubric
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RRubricsModerCreate(
        var fandomId: Long,
        var languageId: Long,
        var name: String,
        var ownerId: Long,
        var comment: String
) : Request<RRubricsModerCreate.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        name = json.m(inp, "name", name)
        ownerId = json.m(inp, "ownerId", ownerId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var rubric = Rubric()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(rubric: Rubric) {
            this.rubric = rubric
        }

        override fun json(inp: Boolean, json: Json) {
            rubric = json.m(inp, "rubric", rubric)
        }

    }

}