package com.dzen.campfire.api.models.publications.moderations.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationLinkAdd : Moderation {

    var title = ""
    var url = ""
    var iconIndex = 0L

    override fun getType() = API.MODERATION_TYPE_LINK_ADD

    constructor()

    constructor(comment: String, title: String,url: String, iconIndex: Long) : super(comment) {
        this.title = title
        this.url = url
        this.iconIndex = iconIndex
    }

    override fun json(inp: Boolean, json: Json): Json {
        url = json.m(inp, "url", url)
        title = json.m(inp, "title", title)
        iconIndex = json.m(inp, "iconIndex", iconIndex)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}