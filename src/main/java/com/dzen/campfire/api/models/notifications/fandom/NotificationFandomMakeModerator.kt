package com.dzen.campfire.api.models.notifications.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationFandomMakeModerator : Notification {

    var fandomId: Long = 0
    var languageId: Long = 0
    var fandomName: String = ""
    var comment: String = ""

    override fun getType() = API.NOTIF_FANDOM_MAKE_MODERATOR

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor() {

    }

    constructor(fandomImageId: Long, fandomId: Long, languageId: Long, fandomName: String, comment: String) : super(fandomImageId) {
        this.fandomId = fandomId
        this.languageId = languageId
        this.fandomName = fandomName
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        comment = json.m(inp, "comment", comment)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
