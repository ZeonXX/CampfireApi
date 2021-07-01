package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostPinFandom(
        var postId: Long,
        var fandomId: Long,
        var languageId: Long,
        var comment: String
) : Request<RPostPinFandom.Response>() {


    override fun jsonSub(inp: Boolean, json: Json) {
        postId = json.m(inp, "postId", postId)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
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
