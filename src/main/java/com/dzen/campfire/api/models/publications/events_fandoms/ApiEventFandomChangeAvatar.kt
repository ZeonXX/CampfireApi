package com.dzen.campfire.api.models.publications.events_fandoms

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventFandomChangeAvatar : ApiEventFandom {

    override fun getType() = API.PUBLICATION_EVENT_FANDOM_CHANGE_AVATAR

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                fandomId: Long,
                fandomName: String,
                fandomImageId: Long,
                comment: String
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            fandomId,
            fandomName,
            fandomImageId,
            comment) {
    }

    override fun json(inp: Boolean, json: Json): Json {
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}