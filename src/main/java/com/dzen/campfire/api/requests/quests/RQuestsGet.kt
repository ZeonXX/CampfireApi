package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.models.quests.QuestDetails
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsGet(var questId: Long) : Request<RQuestsGet.Response>() {
    override fun jsonSub(inp: Boolean, json: Json) {
        questId = json.m(inp, "questId", questId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        var questDetails = QuestDetails()

        constructor(questDetails: QuestDetails) {
            this.questDetails = questDetails
        }
        constructor(json: Json) {
            json(false, json)
        }

        override fun json(inp: Boolean, json: Json) {
            questDetails = json.m(inp, "questDetails", questDetails)
        }
    }
}
