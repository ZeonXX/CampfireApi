package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.activities.UserActivity
import com.dzen.campfire.api.models.publications.PagesContainer
import com.dzen.campfire.api.models.publications.PublicationComment
import com.dzen.campfire.api.models.publications.Publication
import com.sup.dev.java.libs.json.Json

class PublicationPost : Publication, PagesContainer {

    var pages: Array<Page> = emptyArray()
    var bestComment : PublicationComment? = null
    var rubricId = 0L
    var rubricName = ""
    //  App Flags (No Json)
    var isPined = false
    //  User Activity
    var userActivity:UserActivity? = null

    override fun getPublicationTypeConst() = API.PUBLICATION_TYPE_POST

    constructor()

    constructor(jsonDB: Json) : super(jsonDB) {
        restoreFromJsonDB()
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        for(i in 0 until pages.size) pages[i].fillResourcesList(list)
    }

    override fun jsonPublication(inp: Boolean, json: Json) {
        bestComment = json.mNull(inp, "bestComment", bestComment, PublicationComment::class)
        rubricId = json.m(inp, "rubricId", rubricId)
        rubricName = json.m(inp, "rubricName", rubricName)
        userActivity = json.mNull(inp, "userActivity", userActivity, UserActivity::class)
    }

    override fun jsonDBLocal(inp: Boolean, json: Json): Json {
        pages = json.m(inp, "J_PAGES", pages, Array<Page>::class)
        return json
    }

    override fun getPagesArray() = pages
    override fun getSourceType() = API.PAGES_SOURCE_TYPE_POST
    override fun getSourceId() = id
    override fun getSourceIdSub() = 0L
}
