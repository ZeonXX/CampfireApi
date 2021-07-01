package com.dzen.campfire.api.models.notifications.project

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationQuestProgress: Notification {

    var questIndex: Long = 0
    var progress: Long = 0

    override fun isShadow() = true

    override fun isNeedForcePush() = false

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

    override fun getType(): Long {
        return API.NOTIF_QUEST_POGRESS
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
