package com.dzen.campfire.api.requests.rubrics

import com.dzen.campfire.api.models.fandoms.Rubric
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RRubricGet(
        var rubricId: Long
) : Request<RRubricGet.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        rubricId = json.m(inp, "rubricId", rubricId)
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