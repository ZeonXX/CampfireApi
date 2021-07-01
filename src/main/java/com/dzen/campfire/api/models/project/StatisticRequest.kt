package com.dzen.campfire.api.models.project

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class StatisticRequest : JsonParsable {

    var key = ""
    var count = 0L
    var timeMiddle = 0L
    var timeMin = 0L
    var timeMax = 0L
    var timeTotal = 0L

    override fun json(inp: Boolean, json: Json): Json {
        key = json.m(inp, "key", key)
        timeMiddle = json.m(inp, "timeMiddle", timeMiddle)
        timeMin = json.m(inp, "timeMin", timeMin)
        timeMax = json.m(inp, "timeMax", timeMax)
        timeTotal = json.m(inp, "timeTotal", timeTotal)
        count = json.m(inp, "count", count)
        return json
    }

}