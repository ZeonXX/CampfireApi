package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.models.publications.Publication
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostFeedGetAll(
        var offsetDate: Long,
        var languagesId: Array<Long>,
        var categoriesId: Array<Long>,
        var importantOnly: Boolean,
        var karmaCategory: Long,
        var noSubscribes: Boolean,
        var noKarmaCategory: Boolean
) : Request<RPostFeedGetAll.Response>() {

    companion object {
        val COUNT = 10
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offsetDate = json.m(inp, "offsetDate", offsetDate)
        importantOnly = json.m(inp, "importantOnly", importantOnly)
        languagesId = json.m(inp, "languagesId", languagesId)
        categoriesId = json.m(inp, "categoriesId", categoriesId)
        karmaCategory = json.m(inp, "karmaCategory", karmaCategory)
        noSubscribes = json.m(inp, "noSubscribes", noSubscribes)
        noKarmaCategory = json.m(inp, "noKarmaCategory", noKarmaCategory)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publications: Array<Publication> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publications: Array<Publication>) {
            this.publications = publications
        }

        override fun json(inp: Boolean, json: Json) {
            publications = json.m(inp, "units", publications, Array<Publication>::class)
        }

    }



}