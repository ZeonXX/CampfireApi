package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventUserAdminPublicationBlocked : ApiEventUser {

    var blockAccountDate = 0L
    var publicationType = 0L
    var moderationId = 0L
    var lastPublicationsBlocked = false
    var warned = false
    var blockedInApp = false
    var blockFandomName = ""
    var blockFandomId = 0L
    var blockFandomLanguageId = 0L

    override fun getType() =  API.PUBLICATION_EVENT_USER_ADMIN_PUBLICATION_BLOCKED

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
                publicationType: Long,
                moderationId: Long,
                blockAccountDate: Long,
                lastPublicationsBlocked: Boolean,
                warned: Boolean,
                blockedInApp: Boolean,
                blockFandomName: String,
                blockFandomId: Long,
                blockFandomLanguageId: Long
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            adminAccountId,
            adminAccountName,
            adminAccountImageId,
            adminAccountSex,
            comment) {
        this.publicationType = publicationType
        this.moderationId = moderationId
        this.blockAccountDate = blockAccountDate
        this.lastPublicationsBlocked = lastPublicationsBlocked
        this.warned = warned
        this.blockedInApp = blockedInApp
        this.blockFandomName = blockFandomName
        this.blockFandomId = blockFandomId
        this.blockFandomLanguageId = blockFandomLanguageId
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationType = json.m(inp, "unitType", publicationType)
        moderationId = json.m(inp, "moderationId", moderationId)
        blockAccountDate = json.m(inp, "blockAccountDate", blockAccountDate)
        lastPublicationsBlocked = json.m(inp, "lastUnitsBlocked", lastPublicationsBlocked)
        warned = json.m(inp, "warned", warned)
        blockedInApp = json.m(inp, "blockedInApp", blockedInApp)
        blockFandomName = json.m(inp, "blockFandomName", blockFandomName)
        blockFandomId = json.m(inp, "blockFandomId", blockFandomId)
        blockFandomLanguageId = json.m(inp, "blockFandomLanguageId", blockFandomLanguageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}