package com.dzen.campfire.api.models.fandoms

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class KarmaInFandom : JsonParsable {

    var karmaCount = 0L
    var fandom = Fandom()

    override fun json(inp: Boolean, json: Json): Json {
        karmaCount = json.m(inp, "karmaCount", karmaCount)
        fandom = json.m(inp, "fandom", fandom)
        return json
    }

}