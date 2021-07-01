package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectMakeHelloPost(
        var text:String,
        var title:Boolean,
        var text_2:String,
        var languageId:Long
) : Request<RProjectMakeHelloPost.Response>() {

    init {
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        text = json.m(inp, "text", text)
        text_2 = json.m(inp, "text_2", text_2)
        title = json.m(inp, "title", title)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var id = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(id:Long) {
            this.id = id
        }

        override fun json(inp: Boolean, json: Json) {
            id = json.m(inp, "id", id)
        }

    }


}