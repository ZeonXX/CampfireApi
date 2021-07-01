package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class PageText : Page() {

    companion object {

        val SIZE_0 = 0
        val SIZE_1 = 1

        val ALIGN_LEFT = 0
        val ALIGN_RIGHT = 1
        val ALIGN_CENTER = 2

    }

    var text = ""
    var size = 0
    var align = 0
    var icon = 0

    override fun getType() = API.PAGE_TYPE_TEXT

    override fun json(inp: Boolean, json: Json): Json {
        text = json.m(inp, "J_TEXT", text)
        icon = json.m(inp, "icon", icon)
        align = json.m(inp, "align", align)

        if (inp)
            json.put("J_SIZE", size)
        else
            size = json.getInt("J_SIZE", SIZE_0)

        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }


}
