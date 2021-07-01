package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.models.publications.Publication
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesGetPosts(
        var userActivityId: Long,
        var offset: Long
) : Request<RActivitiesGetPosts.Response>() {

    companion object{

        val COUNT = 10

    }

    override fun jsonSub(inp: Boolean, json: Json) {
        userActivityId = json.m(inp, "userActivityId", userActivityId)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var posts:Array<Publication> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(posts:Array<Publication>) {
            this.posts = posts
        }

        override fun json(inp: Boolean, json: Json) {
            posts = json.m(inp, "posts", posts)
        }

    }


}
