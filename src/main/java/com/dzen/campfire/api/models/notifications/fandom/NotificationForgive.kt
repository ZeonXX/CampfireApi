package com.dzen.campfire.api.models.notifications.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationForgive : Notification {

    var fandomId = 0L
    var languageId = 0L
    var fandomName = ""
    var moderatorId = 0L
    var moderatorName = ""
    var moderatorSex = 0L
    var comment = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor()

    constructor(fandomId: Long,
                languageId: Long,
                fandomImageId: Long,
                fandomName: String,
                moderatorId: Long,
                moderatorName: String,
                moderatorSex: Long,
                comment:String) : super(fandomImageId) {
        this.fandomId = fandomId
        this.languageId = languageId
        this.fandomName = fandomName
        this.moderatorId = moderatorId
        this.moderatorName = moderatorName
        this.moderatorSex = moderatorSex
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        moderatorId = json.m(inp, "moderatorId", moderatorId)
        moderatorName = json.m(inp, "moderatorName", moderatorName)
        moderatorSex = json.m(inp, "moderatorSex", moderatorSex)
        comment = json.m(inp, "comment", comment)
        return super.json(inp, json)
    }

    override fun getType(): Long {
        return API.NOTIF_MODERATION_FORGIVE
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
