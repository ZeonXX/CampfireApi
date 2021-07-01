package com.dzen.campfire.api.models.notifications.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationAdminPostFandomChange : Notification {

    var publicationId = 0L
    var oldFandomId = 0L
    var oldLanguageId = 0L
    var oldFandomName = ""
    var newFandomId = 0L
    var newLanguageId = 0L
    var newFandomName = ""
    var adminId = 0L
    var adminName = ""
    var adminSex = 0L
    var comment = ""

    override fun getType() = API.NOTIF_ADMIN_POST_FANDOM_CHANGE

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor() {

    }

    constructor(publicationId: Long,
                oldFandomId: Long,
                oldLanguageId: Long,
                oldFandomName: String,
                newFandomId: Long,
                newLanguageId: Long,
                newFandomName: String,
                adminId: Long,
                adminName: String,
                adminSex: Long,
                fandomImageId: Long,
                comment: String
    ) : super(fandomImageId) {
        this.publicationId = publicationId
        this.oldFandomId = oldFandomId
        this.oldLanguageId = oldLanguageId
        this.oldFandomName = oldFandomName
        this.newFandomId = newFandomId
        this.newLanguageId = newLanguageId
        this.newFandomName = newFandomName
        this.adminId = adminId
        this.adminName = adminName
        this.adminSex = adminSex
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "unitId", publicationId)
        oldFandomId = json.m(inp, "oldFandomId", oldFandomId)
        oldLanguageId = json.m(inp, "oldLanguageId", oldLanguageId)
        oldFandomName = json.m(inp, "oldFandomName", oldFandomName)
        newFandomId = json.m(inp, "newFandomId", newFandomId)
        newLanguageId = json.m(inp, "newLanguageId", newLanguageId)
        newFandomName = json.m(inp, "newFandomName", newFandomName)
        adminId = json.m(inp, "adminId", adminId)
        adminName = json.m(inp, "adminName", adminName)
        adminSex = json.m(inp, "adminSex", adminSex)
        comment = json.m(inp, "comment", comment)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
