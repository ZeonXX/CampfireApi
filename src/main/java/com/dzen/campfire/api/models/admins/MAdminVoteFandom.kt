package com.dzen.campfire.api.models.admins

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.fandoms.Fandom
import com.sup.dev.java.libs.json.Json

abstract class MAdminVoteFandom : MAdminVote {

    var targetFandom = Fandom()

    constructor()

    constructor(adminAccount: Account,
                targetFandom: Fandom,
                comment: String,
    ) : super(
        adminAccount,
        comment,
    ) {
        this.targetFandom = targetFandom;
    }

    override fun json(inp: Boolean, json: Json): Json {
        targetFandom = json.m(inp, "targetFandom", targetFandom)
        return super.json(inp, json)
    }

}