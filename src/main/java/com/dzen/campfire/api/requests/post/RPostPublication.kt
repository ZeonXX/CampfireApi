package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RPostPublication(
        var publicationId: Long,
        var tags: Array<Long>,
        var comment:String,
        var notifyFollowers:Boolean,
        var pendingTime: Long,
        var closed: Boolean,
        var multilingual: Boolean,
        var rubricId: Long,
        var userActivityId: Long,
        var userActivityNextUserId: Long
) : Request<RPostPublication.Response>() {

    companion object {

        val E_BAD_STATUS = "E_BAD_STATUS"
        val E_BAD_TYPE = "E_BAD_TYPE"
        val E_BAD_TAGS = "E_BAD_TAGS"
        val E_FANDOM_NOT_PUBLIC = "E_FANDOM_NOT_PUBLIC"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        tags = json.m(inp, "tags", tags,  Array<Long>::class)
        comment = json.m(inp, "comment", comment)
        notifyFollowers = json.m(inp, "notifyFollowers", notifyFollowers)
        pendingTime = json.m(inp, "pendingTime", pendingTime)
        closed = json.m(inp, "closed", closed)
        multilingual = json.m(inp, "multilingual", multilingual)
        rubricId = json.m(inp, "rubricId", rubricId)
        userActivityId = json.m(inp, "userActivityId", userActivityId)
        userActivityNextUserId = json.m(inp, "userActivityNextUserId", userActivityNextUserId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        constructor(json: Json) {
            json(false, json)
        }

        constructor()

        override fun json(inp: Boolean, json: Json) {

        }

    }

}