package com.dzen.campfire.api.models

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class ApiInfo : JsonParsable {

    override fun json(inp: Boolean, json: Json): Json {
        return json
    }

}
