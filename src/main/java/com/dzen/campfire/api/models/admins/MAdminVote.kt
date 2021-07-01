package com.dzen.campfire.api.models.admins

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonPolimorf

abstract class MAdminVote : JsonPolimorf {

    companion object {

        @JvmStatic
        fun instance(json: Json): MAdminVote {

            val event = when (json.getLong("type")) {
                API.ADMIN_VOTE_ACCOUNT_RECOUNT_ACHI -> MAdminVoteAccountRecountAchi()
                API.ADMIN_VOTE_ACCOUNT_CHANGE_NAME -> MAdminVoteAccountChangeName()
                API.ADMIN_VOTE_ACCOUNT_EFFECT -> MAdminVoteAccountEffect()
                API.ADMIN_VOTE_ACCOUNT_PUNISH -> MAdminVoteAccountPunish()
                API.ADMIN_VOTE_ACCOUNT_RECOUNT_KARMA -> MAdminVoteAccountRecountKarma()
                API.ADMIN_VOTE_ACCOUNT_REMOVE_AVATAR -> MAdminVoteAccountRemoveAvatar()
                API.ADMIN_VOTE_ACCOUNT_REMOVE_BACKGROUND -> MAdminVoteAccountRemoveBackground()
                API.ADMIN_VOTE_ACCOUNT_REMOVE_NAME -> MAdminVoteAccountRemoveName()
                API.ADMIN_VOTE_ACCOUNT_REMOVE_REPORTS -> MAdminVoteAccountRemoveReports()
                API.ADMIN_VOTE_ACCOUNT_REMOVE_STATUS -> MAdminVoteAccountRemoveStatus()
                API.ADMIN_VOTE_FANDOM_REMOVE ->  MAdminVoteFandomRemove()
                else -> MAdminVoteUnknown()
            }

            event.json(false, json)
            return event
        }
    }

    var id = 0L
    var adminAccount = Account()
    var comment = ""

    //  Server only
    var votes = ArrayList<Long>()

    constructor()

    constructor(adminAccount: Account,
                comment: String) : super() {
        this.adminAccount = adminAccount
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        if (inp) json.put("type", getType())
        id = json.m(inp, "id", id)
        adminAccount = json.m(inp, "adminAccount", adminAccount)
        comment = json.m(inp, "comment", comment)
        return json
    }

    abstract fun getType(): Long

}