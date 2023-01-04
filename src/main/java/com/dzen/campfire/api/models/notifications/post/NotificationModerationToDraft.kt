package com.dzen.campfire.api.models.notifications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationModerationToDraft : Notification {

    var comment = ""
    var fandomImageId = 0L
    var moderationId = 0L
    var moderatorSex = 0L
    var moderatorName = ""
    var maskText = ""
    var maskPageType = 0L
    var publicationTyoe = 0L

    constructor()

    override fun getType() = API.NOTIF_MODERATION_TO_DRAFTS

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor(comment: String,
                fandomImageId: Long,
                moderationId: Long,
                moderatorSex: Long,
                moderatorName: String,
                maskText: String,
                maskPageType: Long,
                publicationType: Long = API.PUBLICATION_TYPE_POST,
    ) : super(0) {
        this.comment = comment
        this.fandomImageId = fandomImageId
        this.moderationId = moderationId
        this.moderatorSex = moderatorSex
        this.moderatorName = moderatorName
        this.maskText = maskText
        this.maskPageType = maskPageType
        this.publicationTyoe = publicationType
    }

    override fun json(inp: Boolean, json: Json): Json {
        comment = json.m(inp, "comment", comment)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        moderationId = json.m(inp, "moderationId", moderationId)
        moderatorSex = json.m(inp, "moderatorSex", moderatorSex)
        moderatorName = json.m(inp, "moderatorName", moderatorName)
        maskText = json.m(inp, "maskText", maskText)
        maskPageType = json.m(inp, "maskPageType", maskPageType)
        publicationTyoe = json.m(inp, "publicationTyoe", publicationTyoe)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}