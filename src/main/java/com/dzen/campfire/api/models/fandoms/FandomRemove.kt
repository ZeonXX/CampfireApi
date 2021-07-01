package com.dzen.campfire.api.models.fandoms

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class FandomRemove : JsonParsable {

    var fandom = Fandom()
    var comment = ""
    var accountId = 0L
    var accountName = ""
    var accountImageId = 0L

    override fun json(inp: Boolean, json: Json): Json {
        fandom = json.m(inp, "fandom", fandom)
        comment = json.m(inp, "comment", comment)
        accountId = json.m(inp, "accountId", accountId)
        accountName = json.m(inp, "accountName", accountName)
        accountImageId = json.m(inp, "accountImageId", accountImageId)
        return json
    }

}