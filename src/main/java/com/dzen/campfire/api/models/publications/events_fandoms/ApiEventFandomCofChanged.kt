package com.dzen.campfire.api.models.publications.events_fandoms


import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventFandomCofChanged : ApiEventFandom {

    var oldCof = 0L
    var newCof = 0L

    override fun getType() = API.PUBLICATION_EVENT_FANDOM_KARMA_COF_CHANGED

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                fandomId: Long,
                fandomName: String,
                fandomImageId: Long,
                comment: String,
                oldCof: Long,
                newCof: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            fandomId,
            fandomName,
            fandomImageId,
            comment) {
        this.oldCof = oldCof
        this.newCof = newCof
    }

    override fun json(inp: Boolean, json: Json): Json {
        oldCof = json.m(inp, "oldCof", oldCof)
        newCof = json.m(inp, "newCof", newCof)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}