package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonPolimorf

abstract class QuestEffect : JsonPolimorf {
    var type = API.QUEST_EFFECT_TYPE_UNKNOWN

    init {
        type = this.getEffectType()
    }

    companion object {
        @JvmStatic
        fun instance(type: Long): QuestEffect {
            return when (type) {
                API.QUEST_EFFECT_TYPE_BOX -> QuestEffectBox()
                API.QUEST_EFFECT_TYPE_RESET_BOX -> QuestEffectBoxReset()
                API.QUEST_EFFECT_TYPE_VIBRATE -> QuestEffectVibrate()
                else -> QuestEffectUnknown()
            }
        }

        @JvmStatic
        fun instance(json: Json): QuestEffect {
            val effect = instance(json.getLong("type"))
            effect.json(false, json)
            return effect
        }
    }

    abstract fun getEffectType(): Long

    override fun json(inp: Boolean, json: Json): Json {
        type = json.m(inp, "type", type)
        return json
    }
}
