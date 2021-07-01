package com.dzen.campfire.api.models.admins

import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json

abstract class MAdminVoteAccount : MAdminVote {

    var targetAccount = Account()

    constructor()

    constructor(adminAccount: Account,
                targetAccount: Account,
                comment: String,
    ) : super(
        adminAccount,
        comment,
    ) {
        this.targetAccount = targetAccount;
    }

    override fun json(inp: Boolean, json: Json): Json {
        targetAccount = json.m(inp, "targetAccount", targetAccount)
        return super.json(inp, json)
    }

}