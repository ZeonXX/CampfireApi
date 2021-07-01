package com.dzen.campfire.api.requests.rubrics

import com.dzen.campfire.api.models.fandoms.Rubric
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RRubricsGetAll(
        var fandomId: Long,
        var languageId: Long,
        var ownerId: Long,
        var offset: Long
) : Request<RRubricsGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        ownerId = json.m(inp, "ownerId", ownerId)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var rubrics: Array<Rubric> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(rubrics: Array<Rubric>) {
            this.rubrics = rubrics
        }

        override fun json(inp: Boolean, json: Json) {
            rubrics = json.m(inp, "rubrics", rubrics)
        }

    }

}