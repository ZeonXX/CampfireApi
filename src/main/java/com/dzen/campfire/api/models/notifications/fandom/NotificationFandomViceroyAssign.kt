package com.dzen.campfire.api.models.notifications.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationFandomViceroyAssign : Notification {

    var fandomId = 0L
    var languageId = 0L
    var fandomName = ""
    var comment = ""
    var adminAccountId = 0L
    var adminAccountName = ""
    var adminAccountSex = 0L
    var oldAccountId = 0L
    var oldAccountName = ""
    var newAccountId = 0L
    var newAccountName = ""

    override fun getType()= API.NOTIF_FANDOM_VICEROY_ASSIGN

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor() {

    }

    constructor(fandomImageId: Long,
            fandomId: Long,
                languageId: Long,
                fandomName: String,
                comment: String,
                adminAccountId: Long,
                adminAccountName: String,
                adminAccountSex: Long,
                oldAccountId: Long,
                oldAccountName: String,
                newAccountId: Long,
                newAccountName: String
    ) : super(fandomImageId) {
        this.fandomId = fandomId
        this.languageId = languageId
        this.fandomName = fandomName
        this.comment = comment
        this.adminAccountId = adminAccountId
        this.adminAccountName = adminAccountName
        this.adminAccountSex = adminAccountSex
        this.oldAccountId = oldAccountId
        this.oldAccountName = oldAccountName
        this.newAccountId = newAccountId
        this.newAccountName = newAccountName
    }

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        comment = json.m(inp, "comment", comment)
        adminAccountId = json.m(inp, "adminAccountId", adminAccountId)
        adminAccountName = json.m(inp, "adminAccountName", adminAccountName)
        adminAccountSex = json.m(inp, "adminAccountSex", adminAccountSex)
        oldAccountId = json.m(inp, "oldAccountId", oldAccountId)
        oldAccountName = json.m(inp, "oldAccountName", oldAccountName)
        newAccountId = json.m(inp, "newAccountId", newAccountId)
        newAccountName = json.m(inp, "newAccountName", newAccountName)
        return super.json(inp, json)
    }


    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
