package com.dzen.campfire.api.models.chat

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class ChatParamsFandomSub : JsonParsable {

    var text = ""

    constructor() {

    }

    constructor(text: String) {
        this.text=  text
    }

    constructor(json: Json) {
        json(false, json)
    }

    override fun json(inp: Boolean, json: Json): Json {
        text = json.m(inp, "text", text)
        return json
    }

}