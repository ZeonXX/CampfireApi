package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class PageCode : Page() {
    override fun getType(): Long = API.PAGE_TYPE_CODE

    var code = ""
    // https://github.com/kbiakov/CodeView-Android#list-of-available-languages--their-extensions
    var language = "c"

    override fun json(inp: Boolean, json: Json): Json {
        code = json.m(inp, "code", code)
        language = json.m(inp, "language", language)

        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {}
}