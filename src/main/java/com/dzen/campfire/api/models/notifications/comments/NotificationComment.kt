package com.dzen.campfire.api.models.notifications.comments

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationComment : Notification {

    var publicationId = 0L
    var commentId = 0L
    var accountName = ""
    var accountId = 0L
    var accountSex = 0L
    var parentPublicationType = 0L
    var publicationCreatorId = 0L
    var tag_s_1 = ""
    var commentText = ""
    var commentImageId = 0L
    var commentImagesIds:Array<Long> = emptyArray()
    var fandomName = ""
    var publicationName = ""
    var stickerId = 0L
    var maskText = ""
    var maskPageType = 0L

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_COMMENT

    constructor()

    constructor(imageId: Long,
                publicationId: Long,
                commentId: Long,
                accountId: Long,
                accountSex: Long,
                accountName: String,
                parentPublicationType: Long,
                publicationCreatorId: Long,
                tag_s_1: String,
                commentText: String,
                commentImageId: Long,
                commentImagesIds: Array<Long>,
                fandomName: String,
                publicationName: String,
                stickerId: Long,
                maskText: String,
                maskPageType: Long
    ) : super(imageId) {
        this.publicationId = publicationId
        this.commentId = commentId
        this.accountId = accountId
        this.accountSex = accountSex
        this.accountName = accountName
        this.parentPublicationType = parentPublicationType
        this.publicationCreatorId = publicationCreatorId
        this.tag_s_1 = tag_s_1
        this.commentText = commentText
        this.commentImageId = commentImageId
        this.commentImagesIds = commentImagesIds
        this.fandomName = fandomName
        this.publicationName = publicationName
        this.stickerId = stickerId
        this.maskText = maskText
        this.maskPageType = maskPageType
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "J_UNIT_ID", publicationId)
        commentId = json.m(inp, "J_COMMENT_ID", commentId)
        accountId = json.m(inp, "J_ACCOUNT_ID", accountId)
        accountSex = json.m(inp, "accountSex", accountSex)
        accountName = json.m(inp, "J_ACCOUNT_NAME", accountName)
        parentPublicationType = json.m(inp, "J_PARENT_UNIT_TYPE", parentPublicationType)
        publicationCreatorId = json.m(inp, "unitCreatorId", publicationCreatorId)
        tag_s_1 = json.m(inp, "tag_s_1", tag_s_1)
        commentText = json.m(inp, "commentText", commentText)
        commentImageId = json.m(inp, "commentImageId", commentImageId)
        commentImagesIds = json.m(inp, "commentImagesIds", commentImagesIds)
        fandomName = json.m(inp, "fandomName", fandomName)
        publicationName = json.m(inp, "unitName", publicationName)
        stickerId = json.m(inp, "stickerId", stickerId)
        maskText = json.m(inp, "maskText", maskText)
        maskPageType = json.m(inp, "maskPageType", maskPageType)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
