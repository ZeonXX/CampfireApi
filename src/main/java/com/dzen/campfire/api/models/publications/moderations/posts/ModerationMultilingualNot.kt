package com.dzen.campfire.api.models.publications.moderations.posts

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationMultilingualNot : Moderation {

    var publicationId: Long = 0
    var publicationType: Long = 0
    var accountId: Long = 0
    var accountName: String = ""
    var accountImageId: Long = 0

    override fun getType() = API.MODERATION_TYPE_MULTILINGUAL_NOT

    constructor()

    constructor(comment: String,
                publicationId: Long,
                publicationType: Long,
                accountId: Long,
                accountName: String,
                accountImageId: Long) : super(comment) {
        this.publicationId = publicationId
        this.publicationType = publicationType
        this.accountId = accountId
        this.accountName = accountName
        this.accountImageId = accountImageId
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "unitId", publicationId)
        publicationType = json.m(inp, "unitType", publicationType)
        accountId = json.m(inp, "accountId", accountId)
        accountName = json.m(inp, "accountName", accountName)
        accountImageId = json.m(inp, "accountImageId", accountImageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}