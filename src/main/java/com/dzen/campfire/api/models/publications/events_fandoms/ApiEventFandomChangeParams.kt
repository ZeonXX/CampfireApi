package com.dzen.campfire.api.models.publications.events_fandoms

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventFandomChangeParams : ApiEventFandom {

    var categoryId = 0L
    var paramsPosition = 0
    var newParams:Array<Long> = emptyArray()
    var removedParams:Array<Long> = emptyArray()

    override fun getType() = API.PUBLICATION_EVENT_FANDOM_CHANGE_PARAMS

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                fandomId: Long,
                fandomName: String,
                fandomImageId: Long,
                comment: String,
                categoryId: Long,
                paramsPosition: Int,
                newParams:Array<Long>,
                removedParams:Array<Long>
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            fandomId,
            fandomName,
            fandomImageId,
            comment) {
        this.categoryId = categoryId
        this.paramsPosition = paramsPosition
        this.newParams = newParams
        this.removedParams = removedParams
    }

    override fun json(inp: Boolean, json: Json): Json {
        categoryId = json.m(inp, "categoryId", categoryId)
        paramsPosition = json.m(inp, "paramsPosition", paramsPosition)
        newParams = json.m(inp, "newParams", newParams)
        removedParams = json.m(inp, "removedParams", removedParams)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}