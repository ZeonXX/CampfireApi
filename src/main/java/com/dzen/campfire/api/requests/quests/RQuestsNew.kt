package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.models.quests.QuestDetails
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsNew(
    var title: String,
    var languageId: Long,
) : Request<RQuestsNew.Response>() {
    companion object {
        const val E_INVALID_NAME = "E_INVALID_NAME"
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        title = json.m(inp, "title", title)
        languageId = json.m(inp, "languageId", languageId)
    }

    class Response(
        var quest: QuestDetails = QuestDetails()
    ) : Request.Response() {
        constructor(json: Json) : this() {
            json(false, json)
        }

        override fun json(inp: Boolean, json: Json) {
            quest = json.m(inp, "quest", quest)
        }
    }
}