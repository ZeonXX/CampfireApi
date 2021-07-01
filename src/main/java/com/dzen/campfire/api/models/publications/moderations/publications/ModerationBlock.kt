package com.dzen.campfire.api.models.publications.moderations.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationBlock : Moderation {

    var publicationId = 0L
    var publicationType = 0L
    var accountId = 0L
    var accountName = ""
    var accountImageId = 0L
    var accountBlockDate = 0L
    var lastPublicationsBlocked = false

    var checkAdminId = 0L
    var checkAdminName = ""
    var checkAdminComment = ""

    override fun getType() = API.MODERATION_TYPE_BLOCK

    constructor()

    constructor(comment: String, publicationId: Long, publicationType: Long, accountId: Long, accountName: String, accountImageId: Long, accountBlockDate: Long, lastPublicationsBlocked: Boolean) : super(comment) {
        this.publicationId = publicationId
        this.publicationType = publicationType
        this.accountId = accountId
        this.accountName = accountName
        this.accountImageId = accountImageId
        this.accountBlockDate = accountBlockDate
        this.lastPublicationsBlocked = lastPublicationsBlocked
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "unitId", publicationId)
        publicationType = json.m(inp, "unitType", publicationType)
        accountId = json.m(inp, "accountId", accountId)
        accountName = json.m(inp, "accountName", accountName)
        accountImageId = json.m(inp, "accountImageId", accountImageId)
        accountBlockDate = json.m(inp, "accountBlockDate", accountBlockDate)
        lastPublicationsBlocked = json.m(inp, "lastUnitsBlocked", lastPublicationsBlocked)
        checkAdminId = json.m(inp, "checkAdminId", checkAdminId)
        checkAdminName = json.m(inp, "checkAdminName", checkAdminName)
        checkAdminComment = json.m(inp, "checkAdminComment", checkAdminComment)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}