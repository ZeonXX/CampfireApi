package com.dzen.campfire.api.models.notifications.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.admins.MAdminVote
import com.dzen.campfire.api.models.admins.MAdminVoteUnknown
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.debug.log
import com.sup.dev.java.libs.json.Json

class NotificationAccountAdminVoteCanceledForAdmin : Notification {

    var cancelAdminAccount = Account()
    var actionAdminAccount = Account()
    var mAdminVote:MAdminVote = MAdminVoteUnknown()
    var comment = ""

    constructor() : super()

    constructor(cancelAdminAccount: Account, actionAdminAccount: Account, mAdminVote: MAdminVote, comment:String) : super(cancelAdminAccount.imageId) {
        this.cancelAdminAccount = cancelAdminAccount
        this.actionAdminAccount = actionAdminAccount
        this.mAdminVote = mAdminVote
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        cancelAdminAccount = json.m(inp, "cancelAdminAccount", cancelAdminAccount)
        actionAdminAccount = json.m(inp, "actionAdminAccount", actionAdminAccount)
        mAdminVote = json.m(inp, "mAdminVote", mAdminVote)
        comment = json.m(inp, "comment", comment)
        return super.json(inp, json)
    }

    override fun getType() = API.NOTIF_ACCOUNT_ADMIN_VOTE_CANCELED_FOR_ADMIN

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}