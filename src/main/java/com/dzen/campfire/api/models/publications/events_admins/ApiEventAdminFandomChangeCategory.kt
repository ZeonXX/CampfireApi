package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminFandomChangeCategory : ApiEventAdmin {

    var fandomId = 0L
    var fandomName = ""
    var fandomImageId = 0L
    var oldCategory = 0L
    var newCategory = 0L

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                comment: String,
                fandomId: Long,
                fandomName: String,
                fandomImageId: Long,
                oldCategory: Long,
                newCategory: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            comment) {
        this.fandomId = fandomId
        this.fandomName = fandomName
        this.fandomImageId = fandomImageId
        this.oldCategory = oldCategory
        this.newCategory = newCategory
    }

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_FANDOM_CHANGE_CATEGORY

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomName = json.m(inp, "fandomName", fandomName)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        oldCategory = json.m(inp, "oldCategory", oldCategory)
        newCategory = json.m(inp, "newCategory", newCategory)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}