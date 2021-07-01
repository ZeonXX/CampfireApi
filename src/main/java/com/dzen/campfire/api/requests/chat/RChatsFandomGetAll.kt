package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.publications.chat.Chat
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatsFandomGetAll(
        var offset: Long,
        var fandomId: Long,
        var languageId: Long
) : Request<RChatsFandomGetAll.Response>() {

    companion object {
        val COUNT = 10
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var chats: Array<Chat> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(chats: Array<Chat>) {
            this.chats = chats
        }

        override fun json(inp: Boolean, json: Json) {
            chats = json.m(inp, "chats", chats)
        }

    }


}