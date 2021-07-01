package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.MAccountEffect
import com.sup.dev.java.libs.json.Json

class ApiEventAdminEffectAdd : ApiEventAdmin {

    var mAccountEffect = MAccountEffect()

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_EFFECT_ADD

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
                mAccountEffect: MAccountEffect
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            targetAccountId,
            targetAccountName,
            targetAccountImageId,
            targetAccountSex,
            comment) {
        this.mAccountEffect = mAccountEffect
    }

    override fun json(inp: Boolean, json: Json): Json {
        mAccountEffect = json.m(inp, "mAccountEffect", mAccountEffect)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}