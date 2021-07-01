package com.dzen.campfire.api.requests.achievements

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAchievementsQuestInfo() : Request<RAchievementsQuestInfo.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var questIndex = 0L
        var questProgress = 0L
        var questFinished = false

        constructor(json: Json) {
            json(false, json)
        }

        constructor(questIndex: Long, questProgress: Long, questFinished: Boolean) {
            this.questIndex = questIndex
            this.questProgress = questProgress
            this.questFinished = questFinished
        }

        override fun json(inp: Boolean, json: Json) {
            questIndex = json.m(inp, "questIndex", questIndex)
            questProgress = json.m(inp, "questProgress", questProgress)
            questFinished = json.m(inp, "questFinished", questFinished)
        }

    }


}