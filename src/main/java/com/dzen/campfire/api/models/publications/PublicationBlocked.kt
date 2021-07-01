package com.dzen.campfire.api.models.publications

import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class PublicationBlocked : JsonParsable {

    var publication:Publication = PublicationUnknown()
    var moderationId = 0L
    var moderator = Account()
    var comment = ""
    var lastPublicationsBlocked = false
    var accountBlockDate = 0L
    var accountBlockInApp = false

    override fun json(inp: Boolean, json: Json): Json {
        publication = json.m(inp, "unit", publication, Publication::class)
        moderationId = json.m(inp, "moderationId", moderationId)
        moderator = json.m(inp, "moderator", moderator)
        comment = json.m(inp, "comment", comment)
        lastPublicationsBlocked = json.m(inp, "lastPublicationsBlocked", lastPublicationsBlocked)
        accountBlockDate = json.m(inp, "accountBlockDate", accountBlockDate)
        accountBlockInApp = json.m(inp, "banInApp", accountBlockInApp)
        return json
    }

}