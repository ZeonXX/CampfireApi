package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class QuestPartText : QuestPart() {
    override fun getQuestPartType(): Long = API.QUEST_PART_TYPE_TEXT

    var imageId = 0
    var gifId = 0
    var title = ""
    var text = ""
    var inputs = arrayListOf<QuestInput>()
    var buttons = arrayListOf<QuestButton>()
    var effects = arrayListOf<QuestEffect>()

    override fun json(inp: Boolean, json: Json): Json {
        imageId = json.m(inp, "imageId", imageId)
        gifId = json.m(inp, "gifId", gifId)
        title = json.m(inp, "title", title)
        text = json.m(inp, "text", text)
        inputs = json.m(inp, "inputs", inputs)
        buttons = json.m(inp, "buttons", buttons)
        effects = json.m(inp, "effects", effects)
        return super.json(inp, json)
    }
}
