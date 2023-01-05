package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.models.quests.QuestPart
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsAddPart(
    var questId: Long,
    var parts: Array<QuestPart>,
) : Request<RQuestsAddPart.Response>() {
    companion object {
        const val TOO_MANY_PARTS = "TOO_MANY_PARTS"
        const val BAD_PART = "BAD_PART"
    }

    init {
        for (part in parts) part.addInsertData(this)
    }

    override fun updateDataOutput() {
        val iter = dataOutput.iterator()
        for (part in parts) part.restoreInsertData(iter)
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        questId = json.m(inp, "unitId", questId)
        parts = json.m(inp, "parts", parts, Array<QuestPart>::class)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        var parts: Array<QuestPart> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(parts: Array<QuestPart>) {
            this.parts = parts
        }

        override fun json(inp: Boolean, json: Json) {
            parts = json.m(inp, "parts", parts, Array<QuestPart>::class)
        }
    }
}