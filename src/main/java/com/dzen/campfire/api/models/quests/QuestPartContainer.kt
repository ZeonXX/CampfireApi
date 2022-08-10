package com.dzen.campfire.api.models.quests

interface QuestPartContainer {
    fun getDetails(): QuestDetails

    fun getParts(): Array<QuestPart>
}