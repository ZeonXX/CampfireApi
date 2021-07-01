package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventUserQuestFinish : ApiEventUser {

    var questIndex = 0L
    var questProgress = 0L

    override fun getType() = API.PUBLICATION_EVENT_USER_QUEST_FINISH

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                questIndex: Long,
                questProgress: Long) : super(
            ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            "") {
        this.questIndex = questIndex
        this.questProgress = questProgress
    }

    override fun json(inp: Boolean, json: Json): Json {
        questIndex = json.m(inp, "questIndex", questIndex)
        questProgress = json.m(inp, "questProgress", questProgress)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}