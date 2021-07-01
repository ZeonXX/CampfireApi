package com.dzen.campfire.api.models.publications.events_admins


import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminFandomRemoveModerator : ApiEventAdmin {

    var fandomId = 0L
    var languageId = 0L
    var fandomImageId = 0L
    var fandomName = ""

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                targetAccountId: Long,
                targetAccountName: String,
                targetAccountImageId: Long,
                targetAccountSex: Long,
                comment: String,
                fandomId: Long,
                languageId: Long,
                fandomImageId: Long,
                fandomName: String
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            targetAccountId,
            targetAccountName,
            targetAccountImageId,
            targetAccountSex,
            comment) {
        this.fandomId = fandomId
        this.languageId = languageId
        this.fandomImageId = fandomImageId
        this.fandomName = fandomName
    }

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_FANDOM_REMOVE_MODERATOR

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}