package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class QuestInput : JsonParsable {
    var type = API.QUEST_TYPE_TEXT
    var label: String? = ""
    var hint: String? = ""
    var defaultValue = "" // converted to Long when necessary
    var varId = 0L

    override fun json(inp: Boolean, json: Json): Json {
        type = json.m(inp, "type", type)
        label = json.mNull(inp, "label", label, String::class)
        hint = json.mNull(inp, "hint", hint, String::class)
        defaultValue = json.m(inp, "defaultValue", defaultValue)
        varId = json.m(inp, "varId", varId)
        return json
    }
}
