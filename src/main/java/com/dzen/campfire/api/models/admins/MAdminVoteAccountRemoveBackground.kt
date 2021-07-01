package com.dzen.campfire.api.models.admins

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json

class MAdminVoteAccountRemoveBackground : MAdminVoteAccount {

    constructor()

    override fun getType() = API.ADMIN_VOTE_ACCOUNT_REMOVE_BACKGROUND

    constructor(adminAccount: Account,
                comment: String,
                targetAccount: Account,
    ) : super(
        adminAccount,
        targetAccount,
        comment,
    ) {
    }

    override fun json(inp: Boolean, json: Json): Json {
        return super.json(inp, json)
    }

}