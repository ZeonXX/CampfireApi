package com.dzen.campfire.api.models.publications.moderations.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationForgive : Moderation {

    var accountId: Long = 0
    var accountName: String = ""
    var accountImageId: Long = 0

    override fun getType() = API.MODERATION_TYPE_FORGIVE

    constructor()

    constructor(comment: String,
                accountId: Long,
                accountName: String,
                accountImageId: Long) : super(comment) {
        this.accountId = accountId
        this.accountName = accountName
        this.accountImageId = accountImageId

    }

    override fun json(inp: Boolean, json: Json): Json {
        accountId = json.m(inp, "accountId", accountId)
        accountName = json.m(inp, "accountName", accountName)
        accountImageId = json.m(inp, "accountImageId", accountImageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
