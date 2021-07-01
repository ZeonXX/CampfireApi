package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatRead(
        var tag: ChatTag
) : Request<RChatRead.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        tag = json.m(inp, "tag", tag, ChatTag::class)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var date = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(date: Long) {
            this.date = date
        }

        override fun json(inp: Boolean, json: Json) {
            date = json.m(inp, "date", date)
        }

    }

}