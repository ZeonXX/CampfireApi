package com.dzen.campfire.api.models.account

import com.dzen.campfire.api.API
import com.sup.dev.java.classes.items.Item2
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable
import com.sup.dev.java.tools.ToolsCollections

class AccountLinks : JsonParsable {

    var links = Array(API.ACCOUNT_LINK_MAX){ Item2("", "") }

    constructor()

    constructor(json:String){
        if (!json.isEmpty()) json(false, Json(json))
    }

    override fun json(inp: Boolean, json: Json): Json {
        if (inp) {
            json.put("links", Array(links.size) { Json().put("title", links[it].a1).put("url", links[it].a2) })
        } else {
            val array = json.getJsons("links") ?: emptyArray()
            links = Array(array.size) { Item2(array[it]!!["title"] ?: "", array[it]!!["url"] ?: "") }
        }
        return json
    }

    fun getEmptyIndex():Int{
        for (i in 0 until links.size) if (links[i].a1.isEmpty() && links[i].a2.isEmpty()) return i
        if(links.size < API.ACCOUNT_LINK_MAX) return links.size
        return -1
    }

    fun count(): Int {
        var count = 0
        for (i in links) if (i.a1.isNotEmpty() && i.a2.isNotEmpty()) count++
        return count
    }

    fun set(index: Int, title: String, url: String) {
        if(links.size != API.ACCOUNT_LINK_MAX){
            links = ToolsCollections.expand(links, API.ACCOUNT_LINK_MAX, Item2("", ""))
        }
        links[index].a1 = title
        links[index].a2 = url
    }

}