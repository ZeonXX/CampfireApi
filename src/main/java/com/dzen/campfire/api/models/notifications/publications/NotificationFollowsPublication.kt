package com.dzen.campfire.api.models.notifications.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json


class NotificationFollowsPublication : Notification {

    var publicationId: Long = 0
    var accountSex: Long = 0
    var publicationType: Long = 0
    var accountName: String = ""
    var accountId: Long = 0

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor()

    constructor(imageId: Long, publicationId: Long, publicationType: Long, accountId: Long, accountSex: Long, accountName: String) : super(imageId) {
        this.publicationId = publicationId
        this.publicationType = publicationType
        this.accountId = accountId
        this.accountSex = accountSex
        this.accountName = accountName
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "J_UNIT_ID", publicationId)
        publicationType = json.m(inp, "J_UNIT_TYPE", publicationType)
        accountId = json.m(inp, "J_ACCOUNT_ID", accountId)
        accountSex = json.m(inp, "accountSex", accountSex)
        accountName = json.m(inp, "J_ACCOUNT_NAME", accountName)
        return super.json(inp, json)
    }

    override fun getType(): Long {
        return API.NOTIF_FOLLOWS_PUBLICATION
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
