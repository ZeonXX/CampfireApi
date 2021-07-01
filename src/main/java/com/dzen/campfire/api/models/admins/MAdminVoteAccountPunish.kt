package com.dzen.campfire.api.models.admins

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json

class MAdminVoteAccountPunish : MAdminVoteAccount {

    var banTime = 0L
    var banEndDate = 0L
    var punishId = 0L

    constructor()

    override fun getType() = API.ADMIN_VOTE_ACCOUNT_PUNISH

    constructor(adminAccount: Account,
                comment: String,
                targetAccount: Account,
                banTime: Long,
                banEndDate: Long,
                punishId: Long,
    ) : super(
        adminAccount,
        targetAccount,
        comment,
    ) {
        this.banTime = banTime
        this.banEndDate = banEndDate
        this.punishId = punishId
    }

    override fun json(inp: Boolean, json: Json): Json {
        banTime = json.m(inp, "banTime", banTime)
        banEndDate = json.m(inp, "banEndDate", banEndDate)
        punishId = json.m(inp, "punishId", punishId)
        return super.json(inp, json)
    }

}