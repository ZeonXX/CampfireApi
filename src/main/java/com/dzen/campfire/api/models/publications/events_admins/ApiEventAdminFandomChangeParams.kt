package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminFandomChangeParams : ApiEventAdmin {

    var fandomId = 0L
    var fandomName = ""
    var fandomImageId = 0L
    var categoryId = 0L
    var paramsPosition = 0
    var newParams:Array<Long> = emptyArray()
    var removedParams:Array<Long> = emptyArray()

    constructor()


    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                comment: String,
                fandomId: Long,
                fandomName: String,
                fandomImageId: Long,
                categoryId: Long,
                paramsPosition: Int,
                newParams:Array<Long>,
                removedParams:Array<Long>
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            comment) {
        this.fandomId = fandomId
        this.fandomName = fandomName
        this.fandomImageId = fandomImageId
        this.categoryId = categoryId
        this.paramsPosition = paramsPosition
        this.newParams = newParams
        this.removedParams = removedParams
    }

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_FANDOM_CHANGE_PARAMS

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomName = json.m(inp, "fandomName", fandomName)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        categoryId = json.m(inp, "categoryId", categoryId)
        paramsPosition = json.m(inp, "paramsPosition", paramsPosition)
        newParams = json.m(inp, "newParams", newParams)
        removedParams = json.m(inp, "removedParams", removedParams)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}