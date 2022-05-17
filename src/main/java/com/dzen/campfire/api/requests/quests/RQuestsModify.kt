package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.models.quests.QuestDetails
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsModify(
    var edit: QuestDetails,
) : Request<RQuestsModify.Response>() {
    companion object {
        const val E_INVALID_NAME = "E_INVALID_NAME"
        const val E_INVALID_DESCRIPTION = "E_INVALID_DESCRIPTION"
        const val E_INVALID_VARS = "E_INVALID_VARS"
        const val E_NOT_DRAFT = "E_NOT_DRAFT"
        const val E_INVALID_LANG = "E_INVALID_LANG"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        edit = json.m(inp, "edit", edit)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
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