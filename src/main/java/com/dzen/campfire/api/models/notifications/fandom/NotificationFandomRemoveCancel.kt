package com.dzen.campfire.api.models.notifications.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationFandomRemoveCancel : Notification {

    var fandomId = 0L
    var languageId = 0L
    var fandomName = ""
    var comment = ""
    var adminName = ""
    var adminSex = 0L

    override fun getType() = API.NOTIF_FANDOM_REMOVE_CANCEL

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor() {

    }

    constructor(fandomImageId: Long, fandomId: Long, languageId: Long, fandomName: String, comment: String, adminName: String, adminSex: Long) : super(fandomImageId) {
        this.fandomId = fandomId
        this.languageId = languageId
        this.fandomName = fandomName
        this.comment = comment
        this.adminName = adminName
        this.adminSex = adminSex
    }

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        comment = json.m(inp, "comment", comment)
        adminName = json.m(inp, "adminName", adminName)
        adminSex = json.m(inp, "adminSex", adminSex)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
