package com.dzen.campfire.api.models.notifications.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationModerationRejected : Notification {

    var moderationId = 0L
    var fandomId = 0L
    var languageId = 0L
    var comment = ""
    var adminName = ""
    var adminSex = 0L

    constructor()

    override fun getType() = API.NOTIF_MODERATION_REJECTED

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor(moderationId: Long, fandomId: Long,  languageId: Long, fandomImageId: Long,comment: String,adminName: String,adminSex: Long) : super(fandomImageId) {
        this.comment = comment
        this.moderationId = moderationId
        this.fandomId = fandomId
        this.languageId = languageId
        this.adminName = adminName
        this.adminSex = adminSex
    }

    override fun json(inp: Boolean, json: Json): Json {
        comment = json.m(inp, "comment", comment)
        adminName = json.m(inp, "adminName", adminName)
        moderationId = json.m(inp, "moderationId", moderationId)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        adminSex = json.m(inp, "adminSex", adminSex)
        return super.json(inp, json)
    }


    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}