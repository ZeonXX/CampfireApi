package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventUserAdminViceroyAssign : ApiEventUser {

    override fun getType() = API.PUBLICATION_EVENT_USER_ADMIN_VICEROY_ASSIGN

    var fandomId = 0L
    var fandomLanguageId = 0L
    var fandomName = ""
    var fandomImageId = 0L

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
                fandomId: Long,
                fandomLanguageId: Long,
                fandomName: String,
                fandomImageId: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            adminAccountId,
            adminAccountName,
            adminAccountImageId,
            adminAccountSex,
            comment) {
        this.fandomId= fandomId
        this.fandomLanguageId= fandomLanguageId
        this.fandomName= fandomName
        this.fandomImageId= fandomImageId
    }

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomLanguageId = json.m(inp, "fandomLanguageId", fandomLanguageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}