package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.MAccountEffect
import com.sup.dev.java.libs.json.Json

class ApiEventUserEffectRemove : ApiEventUser {

    var effectId = 0L
    var effectIndex = 0L

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
                effectId: Long,
                effectIndex: Long,
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            adminAccountId,
            adminAccountName,
            adminAccountImageId,
            adminAccountSex,
            comment) {
        this.effectId = effectId
        this.effectIndex = effectIndex
    }

    override fun getType() = API.PUBLICATION_EVENT_USER_EFFECT_REMOVE

    override fun json(inp: Boolean, json: Json): Json {
        effectId = json.m(inp, "effectId", effectId)
        effectIndex = json.m(inp, "effectIndex", effectIndex)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}