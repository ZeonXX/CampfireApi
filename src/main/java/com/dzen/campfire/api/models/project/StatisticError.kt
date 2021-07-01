package com.dzen.campfire.api.models.project

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class StatisticError : JsonParsable {

    var key = ""
    var stack = ""
    var version = ""
    var count = 0L

    override fun json(inp: Boolean, json: Json): Json {
        key = json.m(inp, "key", key)
        stack = json.m(inp, "stack", stack)
        version = json.m(inp, "version", version)
        count = json.m(inp, "count", count)
        return json
    }

}