package com.dzen.campfire.api.models.admins

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.fandoms.Fandom
import com.sup.dev.java.libs.json.Json

class MAdminVoteFandomRemove : MAdminVoteFandom {

    constructor()

    override fun getType() = API.ADMIN_VOTE_FANDOM_REMOVE

    constructor(adminAccount: Account,
                comment: String,
                targetFandom: Fandom,
    ) : super(
        adminAccount,
        targetFandom,
        comment,
    ) {
    }

    override fun json(inp: Boolean, json: Json): Json {
        return super.json(inp, json)
    }

}