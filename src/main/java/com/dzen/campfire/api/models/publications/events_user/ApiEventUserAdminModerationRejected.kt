package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventUserAdminModerationRejected : ApiEventUser {

    var moderationId = 0L
    var fandomName = ""

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
                moderationId: Long,
                fandomName: String
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            adminAccountId,
            adminAccountName,
            adminAccountImageId,
            adminAccountSex,
            comment) {
        this.moderationId = moderationId
        this.fandomName = fandomName
    }


    override fun getType() = API.PUBLICATION_EVENT_USER_ADMIN_MODERATION_REJECTED

    override fun json(inp: Boolean, json: Json): Json {
        moderationId = json.m(inp, "moderationId", moderationId)

        comment = json.m(inp, "comment", comment)
        fandomName = json.m(inp, "fandomName", fandomName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}