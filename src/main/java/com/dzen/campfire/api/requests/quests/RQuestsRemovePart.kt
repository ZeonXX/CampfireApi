package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsRemovePart(
    var questId: Long,
    var partId: Long,
) : Request<RQuestsRemovePart.Response>() {
    override fun jsonSub(inp: Boolean, json: Json) {
        questId = json.m(inp, "unitId", questId)
        partId = json.m(inp, "partId", partId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        constructor()
        constructor(json: Json)
    }
}