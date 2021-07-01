package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminEffectRemove : ApiEventAdmin {

    var effectId = 0L
    var effectIndex = 0L

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_EFFECT_REMOVE

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
                effectId: Long,
                effectIndex: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            targetAccountId,
            targetAccountName,
            targetAccountImageId,
            targetAccountSex,
            comment) {
        this.effectId = effectId
        this.effectIndex = effectIndex
    }

    override fun json(inp: Boolean, json: Json): Json {
        effectId = json.m(inp, "effectId", effectId)
        effectIndex = json.m(inp, "effectIndex", effectIndex)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}