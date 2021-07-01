package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class PageQuote : Page() {

    var author: String = ""
    var text: String = ""

    override fun getType() = API.PAGE_TYPE_QUOTE

    override fun json(inp: Boolean, json: Json): Json {
        text = json.m(inp, "text", text)
        author = json.m(inp, "author", author)

        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}

