package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonPolimorf

abstract class QuestPart : JsonPolimorf {
    companion object {
        @JvmStatic
        fun instance(type: Long): QuestPart {
            return when (type) {
                API.QUEST_PART_TYPE_TEXT -> QuestPartText()
                API.QUEST_PART_TYPE_CONDITION -> QuestPartCondition()
                API.QUEST_PART_TYPE_ACTION -> QuestPartAction()
                else -> QuestPartUnknown()
            }
        }

        @JvmStatic
        fun instance(json: Json): QuestPart {
            val effect = instance(json.getLong("type"))
            effect.json(false, json)
            return effect
        }
    }

    var id = 0L
    var type = API.QUEST_PART_TYPE_UNKNOWN
    var devLabel = ""

    init {
        type = this.getQuestPartType()
    }

    abstract fun getQuestPartType(): Long

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        type = json.m(inp, "type", type)
        devLabel = json.m(inp, "devLabel", devLabel)
        return json
    }
}
