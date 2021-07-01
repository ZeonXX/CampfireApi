package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventUserAdminPostRemoveMedia: ApiEventUser {

    var publicationId = 0L

    override fun getType() =  API.PUBLICATION_EVENT_USER_ADMIN_POST_REMOVE_MEDIA

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
                publication: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            adminAccountId,
            adminAccountName,
            adminAccountImageId,
            adminAccountSex,
            comment) {
        this.publicationId = publication
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "unitId", publicationId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
