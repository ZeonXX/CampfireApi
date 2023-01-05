package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API

class QuestEffectUnknown : QuestEffect() {
    override fun getEffectType(): Long = API.QUEST_EFFECT_TYPE_UNKNOWN
}
