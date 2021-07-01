package com.dzen.campfire.api.requests.comments

import com.dzen.campfire.api.models.publications.PublicationComment
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RCommentGet(
        var parentPublicationId : Long,
        var commentId : Long
) : Request<RCommentGet.Response>() {

    companion object{

        val GONE_BLOCKED = "GONE_BLOCKED"
        val GONE_REMOVE = "REMOVE"

    }

    init {
        tokenRequired = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        parentPublicationId = json.m(inp, "parentPublicationId", parentPublicationId)
        commentId = json.m(inp, "commentId", commentId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var comment = PublicationComment()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(comment: PublicationComment) {
            this.comment = comment
        }

        override fun json(inp: Boolean, json: Json) {
            comment = json.m(inp, "comment", comment)
        }

    }

}