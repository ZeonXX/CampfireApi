package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

class PageCampfireObject : Page() {

    var link = ""


    override fun getType() = API.PAGE_TYPE_CAMPFIRE_OBJECT

    override fun fillResourcesList(list: ArrayList<Long>) {
    }

    override fun addInsertData(request: Request<*>) {
    }

    override fun restoreInsertData(request: Request<*>, offset:Int):Int {
        return 0
    }

    override fun json(inp: Boolean, json: Json): Json {
        link = json.m(inp, "link", link)
        return super.json(inp, json)
    }

}
