package com.dzen.campfire.api.requests.achievements

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAchievementsOnFinish(
        var achievementIndex:Long
) : Request<RAchievementsOnFinish.Response>() {


    override fun jsonSub(inp: Boolean, json: Json) {
        achievementIndex = json.m(inp, "achievementIndex", achievementIndex)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

}