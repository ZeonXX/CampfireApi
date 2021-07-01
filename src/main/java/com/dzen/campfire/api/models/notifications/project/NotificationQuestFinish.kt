package com.dzen.campfire.api.models.notifications.project

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationQuestFinish: Notification {

    var questIndex = 0L
    var progress = 0L

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_QUEST_FINISH

    constructor() {

    }

    constructor(questIndex: Long,progress: Long) : super(0) {
        this.questIndex = questIndex
        this.progress = progress
    }

    override fun json(inp: Boolean, json: Json): Json {
        questIndex = json.m(inp, "questIndex", questIndex)
        progress = json.m(inp, "progress", progress)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
