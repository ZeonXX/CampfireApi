package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationChatChange(
        var chatId: Long,
        var name: String,
        var text: String,
        var comment: String,
        var image:ByteArray?
) : Request<RFandomsModerationChatChange.Response>() {

    companion object {
        val E_BAD_IMAGE_WEIGHT = "E_BAD_IMAGE_WEIGHT"
        val E_BAD_IMAGE_SIZE = "E_BAD_IMAGE_SIZE"
        val E_BAD_NAME_SIZE = "E_BAD_NAME_SIZE"
        val E_BAD_TEXT_SIZE = "E_BAD_TEXT_SIZE"
        val E_BAD_TYPE = "E_BAD_TYPE"
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
        chatId = json.m(inp, "chatId", chatId)
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