package com.dzen.campfire.api.models.translate

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class Translate(
        var text: String,
        var serverFlag_WillUpload:Boolean = false
) : JsonParsable {

    var languageId = 0L
    var key = ""
    var projectKey = ""
    var hint = ""

    constructor() : this("")

    fun setHint(hint: String) :Translate{
        this.hint = hint
        return this
    }

    override fun json(inp: Boolean, json: Json): Json {
        languageId = json.m(inp, "languageId", languageId)
        key = json.m(inp, "key", key)
        text = json.m(inp, "text", text)
        hint = json.m(inp, "hint", hint)
        projectKey = json.m(inp, "projectKey", projectKey)
        return json
    }


}