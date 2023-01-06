package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.models.quests.QuestPart
import com.dzen.campfire.api.models.quests.QuestPartUnknown
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsChangePart(var partId: Long, var part: QuestPart) : Request<RQuestsChangePart.Response>() {
    init {
        part.addInsertData(this)
    }

    override fun updateDataOutput() {
        val iter = dataOutput.iterator()
        part.restoreInsertData(iter)
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        partId = json.m(inp, "partId", partId)
        part = json.m(inp, "part", part)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        var part: QuestPart = QuestPartUnknown()

        constructor(part: QuestPart) {
            this.part = part
        }
        constructor(json: Json) {
            json(false, json)
        }

        override fun json(inp: Boolean, json: Json) {
            part = json.m(inp, "part", part)
        }
    }
}