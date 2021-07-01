package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.publications.chat.Chat
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatsGetAll(var offset: Int) : Request<RChatsGetAll.Response>() {

    companion object {

        val COUNT = 10
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publications: Array<Chat> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publications: Array<Chat>) {
            this.publications = publications
        }

        override fun json(inp: Boolean, json: Json) {
            publications = json.m(inp, "units", publications, Array<Chat>::class)
        }

    }


}