package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatRemove(var tag: ChatTag) : Request<RChatRemove.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        tag = json.m(inp, "tag", tag, ChatTag::class)
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