package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.MAccountEffect
import com.sup.dev.java.libs.json.Json

class ApiEventUserEffectAdd : ApiEventUser {

    var mAccountEffect = MAccountEffect()

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
                mAccountEffect: MAccountEffect
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            adminAccountId,
            adminAccountName,
            adminAccountImageId,
            adminAccountSex,
            comment) {
        this.mAccountEffect = mAccountEffect
    }

    override fun getType() = API.PUBLICATION_EVENT_USER_EFFECT_ADD

    override fun json(inp: Boolean, json: Json): Json {
        mAccountEffect = json.m(inp, "mAccountEffect", mAccountEffect)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}