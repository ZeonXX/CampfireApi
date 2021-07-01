package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatSubscribe(
        var tag : ChatTag,
        var subscribed: Boolean
) : Request<RChatSubscribe.Response>() {

    companion object {
        val E_BAD_CHAT_TYPE = "E_BAD_CHAT_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        tag = json.m(inp, "tag", tag, ChatTag::class)
        subscribed = json.m(inp, "subscribed", subscribed)
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