package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsSaveState(
    var questId: Long,
    var stateVariables: Json,
    var stateIndex: Int,
) : Request<RQuestsSaveState.Response>() {
    companion object {
        const val BAD_STATE = "BAD_STATE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        questId = json.m(inp, "questId", questId)
        stateVariables = json.m(inp, "stateVariables", stateVariables)
        stateIndex = json.m(inp, "stateIndex", stateIndex)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        constructor()
        constructor(json: Json)
    }
}