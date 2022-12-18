package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.dzen.campfire.api.API_TRANSLATE
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class QuestConditionValue : JsonParsable {
    var type = API.QUEST_CONDITION_VALUE_LITERAL_LONG
    var value = 0L
    var sValue: String = ""

    override fun json(inp: Boolean, json: Json): Json {
        type = json.m(inp, "type", type)
        value = json.m(inp, "value", value)
        sValue = json.m(inp, "sValue", sValue)
        return json
    }

    fun getVariableOrNull(details: QuestDetails): QuestVariable? {
        return if (type == API.QUEST_CONDITION_VALUE_VAR)
            details.variablesMap!![value]
        else null
    }
}

class QuestPartCondition : QuestPart() {
    override fun getQuestPartType(): Long = API.QUEST_PART_TYPE_CONDITION

    var leftValue = QuestConditionValue()
    var cond = API.QUEST_CONDITION_EQ
    var rightValue = QuestConditionValue()

    var trueJumpId = 0L
    var falseJumpId = 0L

    override fun json(inp: Boolean, json: Json): Json {
        leftValue = json.m(inp, "leftValue", leftValue)
        cond = json.m(inp, "cond", cond)
        rightValue = json.m(inp, "rightValue", rightValue)
        trueJumpId = json.m(inp, "trueJumpId", trueJumpId)
        falseJumpId = json.m(inp, "falseJumpId", falseJumpId)
        return super.json(inp, json)
    }

    override fun checkValid(details: QuestDetails, parts: List<QuestPart>, errors: MutableList<QuestException>) {
        if (leftValue.type == API.QUEST_CONDITION_VALUE_VAR) {
            assert(errors, details.variablesMap!![leftValue.value] != null) {
                QuestException(API_TRANSLATE.quests_edit_error_3)
            }
        }
        if (rightValue.type == API.QUEST_CONDITION_VALUE_VAR) {
            assert(errors, details.variablesMap!![rightValue.value] != null) {
                QuestException(API_TRANSLATE.quests_edit_error_4)
            }
        }

        assert(errors, trueJumpId < 0 || parts.any { it.id == trueJumpId }) {
            QuestException(API_TRANSLATE.quests_edit_error_5)
        }
        assert(errors, trueJumpId < 0 || parts.any { it.id == falseJumpId }) {
            QuestException(API_TRANSLATE.quests_edit_error_6)
        }
    }
}
