package com.dzen.campfire.api.models.publications

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.fandoms.Fandom
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class Rate : JsonParsable {

    var account = Account()
    var fandom = Fandom()
    var publicationType = 0L
    var karmaCount = 0L
    var date = 0L
    var anonymous = 0L
    var publicationId = 0L
    var publicationParentId = 0L
    var publicationParentType = 0L
    var karmaCof = 0L

    override fun json(inp: Boolean, json: Json): Json {
        account = json.m(inp, "account", account)
        fandom = json.m(inp, "fandom", fandom)
        publicationType = json.m(inp, "unitType", publicationType)
        karmaCount = json.m(inp, "karmaCount", karmaCount)
        date = json.m(inp, "date", date)
        anonymous = json.m(inp, "anonymous", anonymous)
        publicationId = json.m(inp, "unitId", publicationId)
        publicationParentId = json.m(inp, "unitParentId", publicationParentId)
        publicationParentType = json.m(inp, "unitParentType", publicationParentType)
        karmaCof = json.m(inp, "karmaCof", karmaCof)
        return json
    }

}