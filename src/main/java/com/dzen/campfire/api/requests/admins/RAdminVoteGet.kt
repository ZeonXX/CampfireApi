package com.dzen.campfire.api.requests.admins

import com.dzen.campfire.api.models.admins.MAdminVote
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAdminVoteGet(
) : Request<RAdminVoteGet.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var mAdminVote:MAdminVote? = null

        constructor(json: Json) {
            json(false, json)
        }

        constructor(mAdminVote: MAdminVote?) {
            this.mAdminVote = mAdminVote
        }

        override fun json(inp: Boolean, json: Json) {
            mAdminVote = json.mNull(inp, "mAdminVote", mAdminVote, MAdminVote::class)
        }

    }


}
