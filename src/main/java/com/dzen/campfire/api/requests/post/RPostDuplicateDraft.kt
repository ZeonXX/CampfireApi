package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostDuplicateDraft(var postId: Long) : Request<RPostDuplicateDraft.Response>() {
    override fun jsonSub(inp: Boolean, json: Json) {
        postId = json.m(inp, "postId", postId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response(
        var unitId: Long = 0
    ) : Request.Response() {
        constructor(json: Json) : this() {
            json(false, json)
        }

        override fun json(inp: Boolean, json: Json) {
            unitId = json.m(inp, "unitId", unitId)
        }
    }
}
