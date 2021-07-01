package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.publications.chat.PublicationChatMessage
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RChatMessageCreate(
        var tag : ChatTag,
        var text: String,
        var imageArray: Array<ByteArray>?,
        var gif: ByteArray?,
        var voice: ByteArray?,
        var parentMessageId: Long,
        var quoteMessageId: Long,
        var stickerId: Long
) : Request<RChatMessageCreate.Response>() {

    companion object {
        val E_BAD_DATA = "E_BAD_DATA"
        val E_BAD_TEXT = "E_BAD_TEXT"
        val E_BAD_IMAGE = "E_BAD_IMAGE"
        val E_BAD_GIF = "E_BAD_GIF"
        val E_BAD_CHAT_TYPE = "E_BAD_CHAT_TYPE"
        val E_BLACK_LIST = "E_BLACK_LIST"
        val E_IS_IGNORE_VOICE_MESSAGES = "E_IS_IGNORE_VOICE_MESSAGES"
    }

    init {
        addDataOutput(gif)
        addDataOutput(voice)
        if (imageArray != null) for (i in imageArray!!) addDataOutput(i)
    }

    override fun updateDataOutput() {
        gif = dataOutput[0]
        voice = dataOutput[1]
        if (dataOutput.size > 2) {
            imageArray = Array(dataOutput.size - 2) { dataOutput[it + 2]!! }
        }
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        tag = json.m(inp, "tag", tag)
        text = json.m(inp, "text", text)
        parentMessageId = json.m(inp, "parentMessageId", parentMessageId)
        quoteMessageId = json.m(inp, "quoteMessageId", quoteMessageId)
        stickerId = json.m(inp, "stickerId", stickerId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publicationId = 0L
        var message = PublicationChatMessage()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publicationId: Long, message:PublicationChatMessage) {
            this.publicationId = publicationId
            this.message = message
        }

        override fun json(inp: Boolean, json: Json) {
            publicationId = json.m(inp, "unitId", publicationId)
            message = json.m(inp, "message", message)
        }

    }


}