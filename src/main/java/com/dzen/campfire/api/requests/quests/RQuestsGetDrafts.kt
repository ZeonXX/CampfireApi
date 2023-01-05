package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.models.quests.QuestDetails
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsGetDrafts(var offset: Long) : Request<RQuestsGetDrafts.Response>() {
    companion object {
        const val COUNT = 10
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response(
        var quests: Array<QuestDetails> = arrayOf()
    ) : Request.Response() {
        constructor(json: Json) : this() {
            this.json(false, json)
        }

        override fun json(inp: Boolean, json: Json) {
            quests = json.m(inp, "quests", quests)
        }
    }
}
