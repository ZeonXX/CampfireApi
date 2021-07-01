package com.dzen.campfire.api.models.notifications.rubrics

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationRubricsChangeName: Notification {

    var moderationId = 0L
    var adminId = 0L
    var adminName = ""
    var adminSex = 0L
    var rubricId = 0L
    var rubricOldName = ""
    var rubricNewName = ""
    var comment = ""
    var fandomId = 0L
    var languageId = 0L

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_RUBRICS_CHANGE_NAME

    constructor() {

    }

    constructor(
            moderationId:Long,
            rubricId:Long,
            rubricOldName:String,
            rubricNewName:String,
            comment:String,
            adminId: Long,
            adminName: String,
            adminSex:Long,
            fandomImageId:Long,
            fandomId:Long,
            languageId:Long
    ) : super(fandomImageId) {
        this.moderationId = moderationId
        this.rubricId = rubricId
        this.rubricOldName = rubricOldName
        this.rubricNewName = rubricNewName
        this.comment = comment
        this.adminId = adminId
        this.adminName = adminName
        this.adminSex = adminSex
        this.fandomId = fandomId
        this.languageId = languageId
    }

    override fun json(inp: Boolean, json: Json): Json {
        moderationId = json.m(inp, "moderationId", moderationId)
        rubricId = json.m(inp, "rubricId", rubricId)
        rubricOldName = json.m(inp, "rubricOldName", rubricOldName)
        rubricNewName = json.m(inp, "rubricNewName", rubricNewName)
        comment = json.m(inp, "comment", comment)
        adminId = json.m(inp, "adminId", adminId)
        adminName = json.m(inp, "adminName", adminName)
        adminSex = json.m(inp, "adminSex", adminSex)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
