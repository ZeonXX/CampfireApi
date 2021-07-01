package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectDonatesCreateDraft(
        var comment:String,
        var sum:Long
) : Request<RProjectDonatesCreateDraft.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        comment = json.m(inp, "comment", comment)
        sum = json.m(inp, "sum", sum)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var donateId = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(donateId: Long) {
            this.donateId = donateId
        }

        override fun json(inp: Boolean, json: Json) {
            donateId = json.m(inp, "donateId", donateId)
        }

    }

}