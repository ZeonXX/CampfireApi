package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsReorderPart(
    var questId: Long,
    var partId: Long,
    var partIdBefore: Long,
) : Request<RQuestsReorderPart.Response>() {
    override fun jsonSub(inp: Boolean, json: Json) {
        questId = json.m(inp, "questId", questId)
        partId = json.m(inp, "partId", partId)
        partIdBefore = json.m(inp, "partIdBefore", partIdBefore)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        constructor()
        constructor(json: Json)
    }
}