package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatTyping(
        var tag : ChatTag
) : Request<RChatTyping.Response>() {

    companion object {
        val E_BAD_CHAT_TYPE = "E_BAD_CHAT_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        tag = json.m(inp, "tag", tag, ChatTag::class)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }


    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }

}