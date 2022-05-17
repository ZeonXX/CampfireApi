package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsReorderPart(
    var questId: Long,
    var partIndex: Int,
    var targetIndex: Int,
) : Request<RQuestsReorderPart.Response>() {
    override fun jsonSub(inp: Boolean, json: Json) {
        questId = json.m(inp, "questId", questId)
        partIndex = json.m(inp, "partIndex", partIndex)
        targetIndex = json.m(inp, "targetIndex", targetIndex)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        constructor()
        constructor(json: Json)
    }
}