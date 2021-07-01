package com.dzen.campfire.api.models.admins

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.account.MAccountEffect
import com.sup.dev.java.libs.json.Json

class MAdminVoteAccountEffect : MAdminVoteAccount {

    var effectIndex = 0L
    var dateEnd = 0L

    constructor()

    override fun getType() = API.ADMIN_VOTE_ACCOUNT_EFFECT

    constructor(adminAccount: Account,
                comment: String,
                targetAccount: Account,
                effectIndex: Long,
                dateEnd: Long,
    ) : super(
        adminAccount,
        targetAccount,
        comment,
    ) {
        this.effectIndex = effectIndex
        this.dateEnd = dateEnd
    }

    override fun json(inp: Boolean, json: Json): Json {
        effectIndex = json.m(inp, "effectIndex", effectIndex)
        dateEnd = json.m(inp, "dateEnd", dateEnd)
        return super.json(inp, json)
    }

}