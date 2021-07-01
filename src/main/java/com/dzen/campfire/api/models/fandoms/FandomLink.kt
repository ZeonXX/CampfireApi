package com.dzen.campfire.api.models.fandoms

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class FandomLink : JsonParsable {

    companion object {
        val SPLITER = "zle!/---vxка"
    }

    var index: Long = 0
    var url: String = ""
    var title: String = ""
    var imageIndex: Long = 0

    override fun json(inp: Boolean, json: Json): Json {
        index = json.m(inp, "index", index)
        url = json.m(inp, "url", url)
        title = json.m(inp, "title", title)
        imageIndex = json.m(inp, "imageIndex", imageIndex)
        return json
    }

}