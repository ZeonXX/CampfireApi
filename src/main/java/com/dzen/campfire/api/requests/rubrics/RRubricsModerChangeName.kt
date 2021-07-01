package com.dzen.campfire.api.requests.rubrics

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RRubricsModerChangeName(
        var rubricId: Long,
        var newName: String,
        var comment: String
) : Request<RRubricsModerChangeName.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        rubricId = json.m(inp, "rubricId", rubricId)
        newName = json.m(inp, "newName", newName)
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