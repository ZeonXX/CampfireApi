package com.dzen.campfire.api.models.notifications.rubrics

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationRubricsMoveFandom : Notification {
    var moderationId = 0L
    var adminId = 0L
    var adminName = ""
    var adminSex = 0L
    var rubricId = 0L
    var rubricName = ""
    var comment = ""
    var srcFandomId = 0L
    var srcLanguageId = 0L
    var srcFandomName = ""
    var destFandomId = 0L
    var destLanguageId = 0L
    var destFandomName = ""

    override fun fillResourcesList(list: ArrayList<Long>) {}

    override fun getType(): Long = API.NOTIF_RUBRICS_MOVE_FANDOM

    override fun isShadow(): Boolean = false

    override fun isNeedForcePush(): Boolean = true

    constructor()

    constructor(moderationId: Long,
                adminId: Long,
                adminName: String,
                adminSex: Long,
                rubricId: Long,
                rubricName: String,
                comment: String,
                srcFandomId: Long,
                srcLanguageId: Long,
                srcFandomName: String,
                destFandomId: Long,
                destLanguageId: Long,
                destFandomName: String,
                imageId: Long) : super(imageId) {
        this.moderationId = moderationId
        this.adminId = adminId
        this.adminName = adminName
        this.adminSex = adminSex
        this.rubricId = rubricId
        this.rubricName = rubricName
        this.comment = comment
        this.srcFandomId = srcFandomId
        this.srcLanguageId = srcLanguageId
        this.srcFandomName = srcFandomName
        this.destFandomId = destFandomId
        this.destLanguageId = destLanguageId
        this.destFandomName = destFandomName
    }

    override fun json(inp: Boolean, json: Json): Json {
        moderationId = json.m(inp, "moderationId", moderationId)
        adminId = json.m(inp, "adminId", adminId)
        adminName = json.m(inp, "adminName", adminName)
        adminSex = json.m(inp, "adminSex", adminSex)
        rubricId = json.m(inp, "rubricId", rubricId)
        rubricName = json.m(inp, "rubricName", rubricName)
        comment = json.m(inp, "comment", comment)
        srcFandomId = json.m(inp, "srcFandomId", srcFandomId)
        srcLanguageId = json.m(inp, "srcLanguageId", srcLanguageId)
        srcFandomName = json.m(inp, "srcFandomName", srcFandomName)
        destFandomId = json.m(inp, "destFandomId", destFandomId)
        destLanguageId = json.m(inp, "destLanguageId", destLanguageId)
        destFandomName = json.m(inp, "destFandomName", destFandomName)
        return super.json(inp, json)
    }
}