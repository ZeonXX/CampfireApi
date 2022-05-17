package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

class QuestPartText : QuestPart() {
    override fun getQuestPartType(): Long = API.QUEST_PART_TYPE_TEXT

    var imageId = 0L
    var gifId = 0L
    var w = 0
    var h = 0
    var insertBytes: ByteArray? = null
    var insertGifBytes: ByteArray? = null

    var title = ""
    var text = ""
    var inputs = emptyArray<QuestInput>()
    var buttons = emptyArray<QuestButton>()
    var effects = emptyArray<QuestEffect>()

    override fun json(inp: Boolean, json: Json): Json {
        imageId = json.m(inp, "imageId", imageId)
        gifId = json.m(inp, "gifId", gifId)
        w = json.m(inp, "w", w)
        h = json.m(inp, "h", h)
        title = json.m(inp, "title", title)
        text = json.m(inp, "text", text)
        inputs = json.m(inp, "inputs", inputs, Array<QuestInput>::class)
        buttons = json.m(inp, "buttons", buttons, Array<QuestButton>::class)
        effects = json.m(inp, "effects", effects, Array<QuestEffect>::class)
        return super.json(inp, json)
    }

    override fun addInsertData(request: Request<*>) {
        request.addDataOutput(insertBytes)
        request.addDataOutput(insertGifBytes)
    }

    override fun restoreInsertData(dataOutput: Iterator<ByteArray?>) {
        insertBytes = dataOutput.next()
        insertGifBytes = dataOutput.next()
    }
}
