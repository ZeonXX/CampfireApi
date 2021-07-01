package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.models.project.StatisticError
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectStatisticErrors(
        var offset: Long
) : Request<RProjectStatisticErrors.Response>() {

    companion object {
        val COUNT = 20
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var errors:Array<StatisticError> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(errors: Array<StatisticError>) {
            this.errors = errors
        }

        override fun json(inp: Boolean, json: Json) {
            errors = json.m(inp, "errors", errors, Array<StatisticError>::class)
        }

    }

}