package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminFandomRename : ApiEventAdmin {

    var fandomId = 0L
    var fandomImageId = 0L
    var newName = ""
    var oldName = ""

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                comment: String,
                fandomId: Long,
                fandomImageId: Long,
                newName: String,
                oldName: String
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            comment) {
        this.fandomId = fandomId
        this.fandomImageId = fandomImageId
        this.newName = newName
        this.oldName = oldName
    }

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_FANDOM_RENAME

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        newName = json.m(inp, "newName", newName)
        oldName = json.m(inp, "oldName", oldName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}