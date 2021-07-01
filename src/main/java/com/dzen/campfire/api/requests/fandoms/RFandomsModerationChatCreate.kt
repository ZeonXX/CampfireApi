package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationChatCreate(
        var fandomId: Long,
        var languageId: Long,
        var name: String,
        var text: String,
        var comment: String,
        var image:ByteArray?
) : Request<RFandomsModerationChatCreate.Response>() {

    companion object {
        val E_BAD_IMAGE_WEIGHT = "E_BAD_IMAGE_WEIGHT"
        val E_BAD_IMAGE_SIZE = "E_BAD_IMAGE_SIZE"
        val E_BAD_NAME_SIZE = "E_BAD_NAME_SIZE"
        val E_BAD_TEXT_SIZE = "E_BAD_TEXT_SIZE"
    }

    init {
        addDataOutput(image)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        name = json.m(inp, "name", name)
        text = json.m(inp, "text", text)
        comment = json.m(inp, "comment", comment)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var chatTag = ChatTag()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(chatTag: ChatTag) {
            this.chatTag = chatTag
        }

        override fun json(inp: Boolean, json: Json) {
            chatTag = json.m(inp, "chatTag", chatTag)
        }

    }



}