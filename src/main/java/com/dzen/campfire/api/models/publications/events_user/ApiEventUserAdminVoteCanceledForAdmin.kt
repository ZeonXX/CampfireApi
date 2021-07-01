package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.admins.MAdminVote
import com.dzen.campfire.api.models.admins.MAdminVoteUnknown
import com.sup.dev.java.libs.json.Json

class ApiEventUserAdminVoteCanceledForAdmin : ApiEventUser {

    var mAdminVote: MAdminVote = MAdminVoteUnknown();

    override fun getType() =  API.PUBLICATION_EVENT_USER_ADMIN_VOTE_CANCELED_FOR_ADMIN

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                adminAccountId: Long,
                adminAccountName: String,
                adminAccountImageId: Long,
                adminAccountSex: Long,
                comment: String,
                mAdminVote: MAdminVote
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            adminAccountId,
            adminAccountName,
            adminAccountImageId,
            adminAccountSex,
            comment) {
        this.mAdminVote = mAdminVote
    }

    override fun json(inp: Boolean, json: Json): Json {
        mAdminVote = json.m(inp, "mAdminVote", mAdminVote)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}