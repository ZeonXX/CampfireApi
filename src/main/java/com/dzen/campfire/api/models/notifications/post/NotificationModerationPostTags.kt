package com.dzen.campfire.api.models.notifications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationModerationPostTags : Notification {

    var moderatorId = 0L
    var moderatorName = ""
    var moderatorSex = 0L
    var comment: String = ""
    var moderationId: Long = 0

    override fun getType() = API.NOTIF_MODERATION_POST_TAGS

    constructor()

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor(
            moderatorId: Long,
            moderatorName: String,
            moderatorSex: Long,
            moderatorImageId: Long,
            comment: String,
            moderationId: Long
    ) : super(moderatorImageId) {
        this.moderatorId = moderatorId
        this.moderatorName = moderatorName
        this.moderatorSex = moderatorSex
        this.comment = comment
        this.moderationId = moderationId
    }

    override fun json(inp: Boolean, json: Json): Json {
        moderatorId = json.m(inp, "moderatorId", moderatorId)
        moderatorName = json.m(inp, "moderatorName", moderatorName)
        moderatorSex = json.m(inp, "moderatorSex", moderatorSex)
        comment = json.m(inp, "comment", comment)
        moderationId = json.m(inp, "moderationId", moderationId)
        return super.json(inp, json)
    }


    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}