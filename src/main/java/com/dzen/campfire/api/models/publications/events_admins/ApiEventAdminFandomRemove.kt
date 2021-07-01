package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminFandomRemove : ApiEventAdmin {

    var fandomName = ""

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                comment: String,
                fandomName: String
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            comment) {
        this.fandomName = fandomName
    }

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_FANDOM_REMOVE

    override fun json(inp: Boolean, json: Json): Json {
        fandomName = json.m(inp, "fandomName", fandomName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}