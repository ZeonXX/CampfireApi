package com.dzen.campfire.api.models.publications.events_admins


import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminWarn : ApiEventAdmin {

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                targetAccountId: Long,
                targetAccountName: String,
                targetAccountImageId: Long,
                targetAccountSex: Long,
                comment: String
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            targetAccountId,
            targetAccountName,
            targetAccountImageId,
            targetAccountSex,
            comment) {
    }

    override fun getType() =  API.PUBLICATION_EVENT_ADMIN_WARN

    override fun json(inp: Boolean, json: Json): Json {
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}