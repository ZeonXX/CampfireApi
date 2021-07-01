package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.publications.chat.PublicationChatMessage
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatMessageGetAll(
        var tag : ChatTag,
        var offsetDate: Long,
        var old: Boolean,
        var messageId: Long
) : Request<RChatMessageGetAll.Response>() {

    companion object {
        val COUNT = 50
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        tag = json.m(inp, "tag", tag, ChatTag::class)
        offsetDate = json.m(inp, "offsetDate", offsetDate)
        old = json.m(inp, "old", old)
        messageId = json.m(inp, "messageId", messageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publications: Array<PublicationChatMessage> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publications: Array<PublicationChatMessage>) {
            this.publications = publications
        }

        override fun json(inp: Boolean, json: Json) {
            publications = json.m(inp, "units", publications, Array<PublicationChatMessage>::class)
        }

    }

}