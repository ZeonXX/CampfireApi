package com.dzen.campfire.api.models.notifications.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationAccountsFollowsRemove : Notification {

    var accountSex: Long = 0
    var accountId: Long = 0
    var accountName: String = ""

    constructor() : super()

    constructor(imageId: Long, accountId: Long, accountName: String, accountSex: Long) : super(imageId) {
        this.accountId = accountId
        this.accountName = accountName
        this.accountSex = accountSex
    }

    override fun json(inp: Boolean, json: Json): Json {
        accountId = json.m(inp, "J_ACCOUNT_ID", accountId)
        accountSex = json.m(inp, "accountSex", accountSex)
        accountName = json.m(inp, "J_ACCOUNT_NAME", accountName)
        return super.json(inp, json)
    }

    override fun getType() = API.NOTIF_ACCOUNT_FOLLOWS_REMOVE

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(imageId)
    }

}