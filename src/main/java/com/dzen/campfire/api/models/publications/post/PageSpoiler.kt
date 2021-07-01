package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class PageSpoiler : Page() {

    var isOpen = false
    var count = 0
    var name: String? = null

    override fun getType() = API.PAGE_TYPE_SPOILER

    override fun json(inp: Boolean, json: Json): Json {
        count = json.m(inp, "count", count)
        name = json.mNull(inp, "name", name, String::class)

        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}

