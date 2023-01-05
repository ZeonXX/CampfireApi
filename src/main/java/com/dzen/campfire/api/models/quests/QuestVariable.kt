package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class QuestVariable : JsonParsable {
    var devName: String = ""
    var id: Long = 0L
    var type: Long = API.QUEST_TYPE_TEXT

    override fun json(inp: Boolean, json: Json): Json {
        devName = json.m(inp, "devName", devName)
        id = json.m(inp, "id", id)
        type = json.m(inp, "type", type)
        return json
    }
}
