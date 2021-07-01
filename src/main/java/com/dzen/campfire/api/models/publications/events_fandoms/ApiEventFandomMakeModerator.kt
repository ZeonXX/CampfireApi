package com.dzen.campfire.api.models.publications.events_fandoms

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventFandomMakeModerator : ApiEventFandom {

    var fandomLanguageId = 0L
    var targetAccountId = 0L
    var targetAccountImageId = 0L
    var targetAccountName = ""
    var targetAccountSex = 0L

    override fun getType() = API.PUBLICATION_EVENT_FANDOM_MAKE_MODERATOR

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                targetAccountId: Long,
                targetAccountName: String,
                targetAccountImageId: Long,
                targetAccountSex: Long,
                fandomId: Long,
                fandomLanguageId: Long,
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
        this.fandomLanguageId = fandomLanguageId
        this.targetAccountId = targetAccountId
        this.targetAccountImageId = targetAccountImageId
        this.targetAccountName = targetAccountName
        this.targetAccountSex = targetAccountSex
    }

    override fun json(inp: Boolean, json: Json): Json {
        fandomLanguageId = json.m(inp, "fandomLanguageId", fandomLanguageId)
        targetAccountId = json.m(inp, "targetAccountId", targetAccountId)
        targetAccountName = json.m(inp, "targetAccountName", targetAccountName)
        targetAccountImageId = json.m(inp, "targetAccountImageId", targetAccountImageId)
        targetAccountSex = json.m(inp, "targetAccountSex", targetAccountSex)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}