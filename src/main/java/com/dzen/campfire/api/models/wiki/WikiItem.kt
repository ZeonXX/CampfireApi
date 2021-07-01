package com.dzen.campfire.api.models.wiki

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class WikiItem : JsonParsable{

    var id = 0L
    var fandomId = 0L
    var status = 0L

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        fandomId = json.m(inp, "fandomId", fandomId)
        status = json.m(inp, "status", status)

        return json
    }

}