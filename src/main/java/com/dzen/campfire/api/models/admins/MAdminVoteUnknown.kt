package com.dzen.campfire.api.models.admins

import com.dzen.campfire.api.API

class MAdminVoteUnknown : MAdminVote {

    constructor()

    override fun getType() = API.ADMIN_VOTE_UNKNOWN

}
