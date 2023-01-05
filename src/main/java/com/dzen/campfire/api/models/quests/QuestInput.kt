package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class QuestInput : JsonParsable {
    var type = API.QUEST_TYPE_TEXT
    var hint = ""
    var defaultValue = "" // converted to Long when necessary
    var varId = 0L

    override fun json(inp: Boolean, json: Json): Json {
        type = json.m(inp, "type", type)
        hint = json.m(inp, "hint", hint)
        defaultValue = json.m(inp, "defaultValue", defaultValue)
        varId = json.m(inp, "varId", varId)
        return json
    }
}
