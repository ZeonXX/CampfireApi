package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.fandoms.Fandom
import com.dzen.campfire.api.models.fandoms.FandomLink
import com.dzen.campfire.api.models.publications.post.PublicationPost
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsGetPinedPost(
        var fandomId: Long,
        var languageId: Long
) : Request<RFandomsGetPinedPost.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var pinnedPost:PublicationPost? = null

        constructor(json: Json) {
            json(false, json)
        }

        constructor(
                    pinnedPost: PublicationPost?
        ) {
            this.pinnedPost = pinnedPost
        }

        override fun json(inp: Boolean, json: Json) {
            pinnedPost = json.mNull(inp, "pinnedPost", pinnedPost, PublicationPost::class)
        }

    }

}