package com.dzen.campfire.api.models.publications.events_fandoms


import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventFandomViceroyRemove : ApiEventFandom {

    var oldAccountId = 0L
    var oldAccountName = ""

    override fun getType() = API.PUBLICATION_EVENT_FANDOM_VICEROY_REMOVE

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
                oldAccountName: String
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
    }

    override fun json(inp: Boolean, json: Json): Json {
        oldAccountId = json.m(inp, "oldAccountId", oldAccountId)
        oldAccountName = json.m(inp, "oldAccountName", oldAccountName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}