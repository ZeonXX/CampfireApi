package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventUserAdminBaned : ApiEventUser {

    var blockDate = 0L

    override fun getType() =  API.PUBLICATION_EVENT_USER_ADMIN_BANED

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
                blockDate: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            adminAccountId,
            adminAccountName,
            adminAccountImageId,
            adminAccountSex,
            comment) {
        this.blockDate = blockDate
    }

    override fun json(inp: Boolean, json: Json): Json {
        blockDate = json.m(inp, "blockDate", blockDate)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}