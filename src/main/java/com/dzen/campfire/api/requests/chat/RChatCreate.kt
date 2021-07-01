package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatCreate(
        var name : String,
        var image:ByteArray?
) : Request<RChatCreate.Response>() {

    init {
        addDataOutput(image)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
    }
    override fun jsonSub(inp: Boolean, json: Json) {
        name = json.m(inp, "name", name)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var tag = ChatTag()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(tag: ChatTag) {
            this.tag = tag
        }

        override fun json(inp: Boolean, json: Json) {
            tag = json.m(inp, "tag", tag)
        }

    }

}