package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminFandomKarmaCofChanged : ApiEventAdmin {

    var fandomId = 0L
    var fandomImageId = 0L
    var fandomName = ""
    var oldCof = 0L
    var newCof = 0L

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                comment: String,
                fandomId: Long,
                fandomImageId: Long,
                fandomName: String,
                oldCof: Long,
                newCof: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            comment) {
        this.fandomId = fandomId
        this.fandomImageId = fandomImageId
        this.fandomName = fandomName
        this.oldCof = oldCof
        this.newCof = newCof
    }

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_FANDOM_COF_CHANGED

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        oldCof = json.m(inp, "oldCof", oldCof)
        newCof = json.m(inp, "newCof", newCof)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}