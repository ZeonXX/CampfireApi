package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class QuestButton : JsonParsable {
    var label = ""
    var color = API.QUEST_BUTTON_COLOR_DEFAULT
    var jumpToId = 0L // -1 => finish quest, -2 => next part

    override fun json(inp: Boolean, json: Json): Json {
        label = json.m(inp, "label", label)
        color = json.m(inp, "color", color)
        jumpToId = json.m(inp, "jumpToId", jumpToId)
        return json
    }
}
