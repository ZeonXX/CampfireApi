package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostMoveRubric(
    var postId: Long,
    var rubricId: Long,
) : Request<RPostMoveRubric.Response>() {
    companion object {
        const val E_OLD = "E_OLD"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        postId = json.m(inp, "postId", postId)
        rubricId = json.m(inp, "rubricId", rubricId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response()
}
