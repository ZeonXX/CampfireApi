package com.dzen.campfire.api.requests.rubrics

import com.dzen.campfire.api.models.fandoms.Rubric
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RRubricsGetParams(
        var rubricId: Long
) : Request<RRubricsGetParams.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        rubricId = json.m(inp, "rubricId", rubricId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var isNotification = false

        constructor(json: Json) {
            json(false, json)
        }

        constructor(isNotification:Boolean) {
            this.isNotification = isNotification
        }

        override fun json(inp: Boolean, json: Json) {
            isNotification = json.m(inp, "isNotification", isNotification)
        }

    }

}