package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostPinAccount(
        var postId: Long
) : Request<RPostPinAccount.Response>() {


    override fun jsonSub(inp: Boolean, json: Json) {
        postId = json.m(inp, "postId", postId)
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
