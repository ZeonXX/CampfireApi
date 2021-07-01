package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.publications.chat.Chat
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatGet(
        var tag : ChatTag,
        var messageId:Long
) : Request<RChatGet.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        tag = json.m(inp, "tag", tag)
        messageId = json.m(inp, "messageId", messageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var chat = Chat()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(chat: Chat) {
            this.chat = chat
        }

        override fun json(inp: Boolean, json: Json) {
            chat = json.m(inp, "chat", chat)
        }

    }


}