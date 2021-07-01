package com.dzen.campfire.api.models.notifications.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationKarmaAdd : Notification {

    var publicationId = 0L
    var publicationType = 0L
    var parentPublicationId = 0L
    var parentPublicationType = 0L
    var karmaCount = 0L
    var accountName = ""
    var accountId = 0L
    var accountSex = 0L
    var tag_s_1 = ""
    var maskText = ""
    var maskPageType = 0L

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor() {

    }

    constructor(imageId: Long, publicationId: Long, publicationType: Long, parentPublicationId: Long, karmaCount: Long,
                accountId: Long, accountSex: Long, parentPublicationType: Long, accountName: String, tag_s_1: String,
                maskText: String, maskPageType: Long) : super(imageId) {
        this.publicationId = publicationId
        this.publicationType = publicationType
        this.parentPublicationId = parentPublicationId
        this.parentPublicationType = parentPublicationType
        this.karmaCount = karmaCount
        this.accountId = accountId
        this.accountSex = accountSex
        this.accountName = accountName
        this.tag_s_1 = tag_s_1
        this.maskText = maskText
        this.maskPageType = maskPageType
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "J_UNIT_ID", publicationId)
        publicationType = json.m(inp, "J_UNIT_TYPE", publicationType)
        parentPublicationId = json.m(inp, "J_PARENT_UNIT_ID", parentPublicationId)
        parentPublicationType = json.m(inp, "J_PARENT_UNIT_TYPE", parentPublicationType)
        karmaCount = json.m(inp, "J_KARMA_COUNT", karmaCount)
        accountId = json.m(inp, "J_ACCOUNT_ID", accountId)
        accountSex = json.m(inp, "accountSex", accountSex)
        accountName = json.m(inp, "J_ACCOUNT_NAME", accountName)
        tag_s_1 = json.m(inp, "tag_s_1", tag_s_1)
        maskText = json.m(inp, "maskText", maskText)
        maskPageType = json.m(inp, "maskPageType", maskPageType)
        return super.json(inp, json)
    }

    override fun getType(): Long {
        return API.NOTIF_KARMA_ADD
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
