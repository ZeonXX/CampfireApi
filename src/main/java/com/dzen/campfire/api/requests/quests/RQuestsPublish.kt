package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsPublish(
    var questId: Long,
) : Request<RQuestsPublish.Response>() {
    companion object {
        const val BAD_PART = "BAD_PART"
        const val NO_DESCRIPTION = "NO_DESCRIPTION"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        questId = json.m(inp, "questId", questId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        constructor()
        constructor(json: Json)
    }
}