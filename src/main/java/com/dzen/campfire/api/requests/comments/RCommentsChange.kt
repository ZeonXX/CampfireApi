package com.dzen.campfire.api.requests.comments

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RCommentsChange(
        var commentId: Long,
        var text: String,
        var quoteId: Long
) : Request<RCommentsChange.Response>() {

    companion object {
        val E_BAD_TEXT_SIZE = "E_BAD_NAME_SIZE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        commentId = json.m(inp, "commentId", commentId)
        quoteId = json.m(inp, "quoteId", quoteId)
        text = json.m(inp, "text", text)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }

}
