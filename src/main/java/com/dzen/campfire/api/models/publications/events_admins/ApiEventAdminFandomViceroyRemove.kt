package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminFandomViceroyRemove : ApiEventAdmin {

    var oldAccountId = 0L
    var oldAccountName = ""
    var fandomId = 0L
    var fandomName = ""
    var fandomImageId = 0L
    var fandomLanguageId = 0L

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                comment: String,
                oldAccountId: Long,
                oldAccountName: String,
                fandomId: Long,
                fandomName: String,
                fandomImageId: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            comment) {
        this.oldAccountId = oldAccountId
        this.oldAccountName = oldAccountName
        this.fandomId = fandomId
        this.fandomName = fandomName
        this.fandomImageId = fandomImageId
    }

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_FANDOM_VICEROY_REMOVE

    override fun json(inp: Boolean, json: Json): Json {
        oldAccountId = json.m(inp, "oldAccountId", oldAccountId)
        oldAccountName = json.m(inp, "oldAccountName", oldAccountName)
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomName = json.m(inp, "fandomName", fandomName)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}