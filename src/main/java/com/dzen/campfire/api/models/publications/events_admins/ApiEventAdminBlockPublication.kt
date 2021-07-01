package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventAdminBlockPublication : ApiEventAdmin {

    var publicationType = 0L
    var blockAccountDate = 0L
    var lastPublicationsBlocked = false
    var warned = false
    var blockedInApp = false
    var blockFandomName = ""
    var blockFandomId = 0L
    var blockFandomLanguageId = 0L

    override fun getType() =  API.PUBLICATION_EVENT_ADMIN_BLOCK_PUBLICATION

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                targetAccountId: Long,
                targetAccountName: String,
                targetAccountImageId: Long,
                targetAccountSex: Long,
                comment: String,
                publicationType: Long,
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
            targetAccountId,
            targetAccountName,
            targetAccountImageId,
            targetAccountSex,
            comment) {
        this.publicationType = publicationType
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