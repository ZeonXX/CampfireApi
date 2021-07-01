package com.dzen.campfire.api.requests.chat


import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.publications.chat.PublicationChatMessage
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatMessageGet(
        var tag : ChatTag,
        var messageId:Long
) : Request<RChatMessageGet.Response>() {

    companion object{

        val GONE_BLOCKED = "GONE_BLOCKED"
        val GONE_REMOVE = "REMOVE"

    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        tag = json.m(inp, "tag", tag, ChatTag::class)
        messageId = json.m(inp, "messageId", messageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publication = PublicationChatMessage()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publication: PublicationChatMessage) {
            this.publication = publication
        }

        override fun json(inp: Boolean, json: Json) {
            publication = json.m(inp, "publication", publication)
        }

    }

}