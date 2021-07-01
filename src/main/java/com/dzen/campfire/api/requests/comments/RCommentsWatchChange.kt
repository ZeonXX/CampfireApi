package com.dzen.campfire.api.requests.comments

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RCommentsWatchChange(
        var publicationId: Long
) : Request<RCommentsWatchChange.Response>() {

    companion object {
        val E_BAD_PUBLICATION_TYPE = "E_BAD_PUBLICATION_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {


        var follow = false

        constructor(json: Json) {
            json(false, json)
        }

        constructor(follow: Boolean) {
            this.follow = follow
        }

        override fun json(inp: Boolean, json: Json) {
            follow = json.m(inp, "follow", follow)
        }

    }

}