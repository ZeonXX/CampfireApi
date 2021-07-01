package com.dzen.campfire.api.models.admins

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json

class MAdminVoteAccountChangeName : MAdminVoteAccount {

    var newName = ""

    constructor()

    override fun getType() = API.ADMIN_VOTE_ACCOUNT_CHANGE_NAME

    constructor(adminAccount: Account,
                comment: String,
                targetAccount: Account,
                newName: String,
    ) : super(
        adminAccount,
        targetAccount,
        comment,
    ) {
        this.newName = newName
    }

    override fun json(inp: Boolean, json: Json): Json {
        newName = json.m(inp, "newName", newName)
        return super.json(inp, json)
    }

}