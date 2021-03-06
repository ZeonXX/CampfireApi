package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.admins.MAdminVote
import com.dzen.campfire.api.models.admins.MAdminVoteUnknown
import com.dzen.campfire.api.models.publications.events_user.ApiEventUser
import com.sup.dev.java.libs.json.Json

class ApiEventUserAdminVoteCanceledForUser : ApiEventUser {

    var mAdminVote:MAdminVote = MAdminVoteUnknown();

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                targetAccountId: Long,
                targetAccountName: String,
                targetAccountImageId: Long,
                targetAccountSex: Long,
                comment: String,
                mAdminVote: MAdminVote
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            targetAccountId,
            targetAccountName,
            targetAccountImageId,
            targetAccountSex,
            comment) {
        this.mAdminVote = mAdminVote
    }


    override fun getType() = API.PUBLICATION_EVENT_USER_ADMIN_VOTE_CANCELED_FOR_USER

    override fun json(inp: Boolean, json: Json): Json {
        mAdminVote = json.m(inp, "mAdminVote", mAdminVote)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}