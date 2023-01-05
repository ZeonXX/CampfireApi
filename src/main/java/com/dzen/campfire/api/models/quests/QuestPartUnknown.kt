package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API

class QuestPartUnknown : QuestPart() {
    override fun getQuestPartType(): Long = API.QUEST_PART_TYPE_UNKNOWN
}
