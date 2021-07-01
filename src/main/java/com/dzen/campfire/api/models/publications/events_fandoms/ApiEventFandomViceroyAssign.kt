package com.dzen.campfire.api.models.publications.events_fandoms

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventFandomViceroyAssign : ApiEventFandom {

    var oldAccountId = 0L
    var oldAccountName = ""
    var newAccountId = 0L
    var newAccountName = ""

    override fun getType() = API.PUBLICATION_EVENT_FANDOM_VICEROY_ASSIGN

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                fandomId: Long,
                fandomName: String,
                fandomImageId: Long,
                comment: String,
                oldAccountId: Long,
                oldAccountName: String,
                newAccountId: Long,
                newAccountName: String
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            fandomId,
            fandomName,
            fandomImageId,
            comment) {
        this.oldAccountId = oldAccountId
        this.oldAccountName = oldAccountName
        this.newAccountId = newAccountId
        this.newAccountName = newAccountName
    }

    override fun json(inp: Boolean, json: Json): Json {
        oldAccountId = json.m(inp, "oldAccountId", oldAccountId)
        oldAccountName = json.m(inp, "oldAccountName", oldAccountName)
        newAccountId = json.m(inp, "newAccountId", newAccountId)
        newAccountName = json.m(inp, "newAccountName", newAccountName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}