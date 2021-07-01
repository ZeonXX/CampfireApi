package com.dzen.campfire.api.models.notifications.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationPublicationImportant : Notification {

    var publicationId = 0L
    var fandomId = 0L
    var fandomLanguageId = 0L
    var fandomName = ""
    var comment = ""
    var moderatorAccountId = 0L

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_PUBLICATION_IMPORTANT

    constructor() {

    }

    constructor(publicationId:Long, moderatorAccountId: Long, fandomImageId: Long, fandomId: Long, fandomLanguageId: Long, fandomName: String, comment: String) : super(fandomImageId) {
        this.publicationId = publicationId
        this.fandomId = fandomId
        this.fandomLanguageId = fandomLanguageId
        this.moderatorAccountId = moderatorAccountId
        this.fandomName = fandomName
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "unitId", publicationId)
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomLanguageId = json.m(inp, "fandomLanguageId", fandomLanguageId)
        moderatorAccountId = json.m(inp, "moderatorAccountId", moderatorAccountId)
        fandomName = json.m(inp, "fandomName", fandomName)
        comment = json.m(inp, "comment", comment)
        return super.json(inp, json)
    }


    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
