package com.dzen.campfire.api.requests.admins

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAdminVoteAccept(
        var voteId:Long,
) : Request<RAdminVoteAccept.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        voteId = json.m(inp, "voteId", voteId)
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
