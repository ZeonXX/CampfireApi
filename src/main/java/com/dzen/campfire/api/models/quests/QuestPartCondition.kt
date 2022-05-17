package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class QuestConditionValue : JsonParsable {
    var type = API.QUEST_CONDITION_VALUE_LITERAL
    var value = 0
    var sValue: String? = ""

    override fun json(inp: Boolean, json: Json): Json {
        type = json.m(inp, "type", type)
        value = json.m(inp, "value", value)
        sValue = json.mNull(inp, "sValue", sValue, String::class)
        return json
    }
}

class QuestPartCondition : QuestPart() {
    override fun getQuestPartType(): Long = API.QUEST_PART_TYPE_CONDITION

    var leftValue = QuestConditionValue()
    var cond = API.QUEST_CONDITION_EQ
    var rightValue = QuestConditionValue()

    var trueJumpId = 0
    var falseJumpId = 0

    override fun json(inp: Boolean, json: Json): Json {
        leftValue = json.m(inp, "leftValue", leftValue)
        cond = json.m(inp, "cond", cond)
        rightValue = json.m(inp, "rightValue", rightValue)
        trueJumpId = json.m(inp, "trueJumpId", trueJumpId)
        falseJumpId = json.m(inp, "falseJumpId", falseJumpId)
        return super.json(inp, json)
    }
}
