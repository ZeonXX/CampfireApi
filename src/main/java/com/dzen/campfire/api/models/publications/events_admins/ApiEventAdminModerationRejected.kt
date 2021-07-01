package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminModerationRejected : ApiEventAdmin {

    var moderationId = 0L

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
                moderationId: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            targetAccountId,
            targetAccountName,
            targetAccountImageId,
            targetAccountSex,
            comment) {
        this.moderationId = moderationId
    }


    override fun getType() = API.PUBLICATION_EVENT_ADMIN_MODERATION_REJECTED

    override fun json(inp: Boolean, json: Json): Json {
        moderationId = json.m(inp, "moderationId", moderationId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}