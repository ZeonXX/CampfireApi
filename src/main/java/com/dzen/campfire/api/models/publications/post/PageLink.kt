package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class PageLink : Page() {

    var name: String = ""
    var link: String = ""

    override fun getType() = API.PAGE_TYPE_LINK

    override fun json(inp: Boolean, json: Json): Json {
        name = json.m(inp, "name", name)
        link = json.m(inp, "link", link)

        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}

