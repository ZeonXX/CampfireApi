package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventUserAdminPostChangeFandom: ApiEventUser {

    var publicationId = 0L
    var oldFandomId = 0L
    var oldLanguageId = 0L
    var oldFandomName = ""
    var newFandomId = 0L
    var newLanguageId = 0L
    var newFandomName = ""

    override fun getType() =  API.PUBLICATION_EVENT_USER_ADMIN_POST_CHANGE_FANDOM

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                adminAccountId: Long,
                adminAccountName: String,
                adminAccountImageId: Long,
                adminAccountSex: Long,
                comment: String,
                publication: Long,
                oldFandomId: Long,
                oldLanguageId: Long,
                oldFandomName: String,
                newFandomId: Long,
                newLanguageId: Long,
                newFandomName: String
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            adminAccountId,
            adminAccountName,
            adminAccountImageId,
            adminAccountSex,
            comment) {
        this.publicationId = publication
        this.oldFandomId = oldFandomId
        this.oldLanguageId = oldLanguageId
        this.oldFandomName = oldFandomName
        this.newFandomId = newFandomId
        this.newLanguageId = newLanguageId
        this.newFandomName = newFandomName
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "unitId", publicationId)
        oldFandomId = json.m(inp, "oldFandomId", oldFandomId)
        oldLanguageId = json.m(inp, "oldLanguageId", oldLanguageId)
        oldFandomName = json.m(inp, "oldFandomName", oldFandomName)
        newFandomId = json.m(inp, "newFandomId", newFandomId)
        newLanguageId = json.m(inp, "newLanguageId", newLanguageId)
        newFandomName = json.m(inp, "newFandomName", newFandomName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
