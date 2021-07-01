package com.dzen.campfire.api.models

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class BookmarksFolder : JsonParsable {

    var id = 0L
    var name = ""

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        name = json.m(inp, "name", name)
        return json
    }

}
