package com.dzen.campfire.api.models.publications.events_fandoms

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventFandomChangeCategory : ApiEventFandom {

    var oldCategory = 0L
    var newCategory = 0L

    override fun getType() = API.PUBLICATION_EVENT_FANDOM_CHANGE_CATEGORY

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                fandomId: Long,
                fandomName: String,
                fandomImageId: Long,
                comment: String,
                oldCategory: Long,
                newCategory: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            fandomId,
            fandomName,
            fandomImageId,
            comment) {
        this.oldCategory = oldCategory
        this.newCategory = newCategory
    }

    override fun json(inp: Boolean, json: Json): Json {
        oldCategory = json.m(inp, "oldCategory", oldCategory)
        newCategory = json.m(inp, "newCategory", newCategory)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}