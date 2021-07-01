package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminFandomClose : ApiEventAdmin {

    var fandomId = 0L
    var fandomImageId = 0L
    var fandomName = ""
    var closed = false

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                comment: String,
                fandomId: Long,
                fandomImageId: Long,
                fandomName: String,
                closed: Boolean
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            comment) {
        this.fandomId = fandomId
        this.fandomImageId = fandomImageId
        this.fandomName = fandomName
        this.closed = closed
    }

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_FANDOM_CLOSE

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        closed = json.m(inp, "closed", closed)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}