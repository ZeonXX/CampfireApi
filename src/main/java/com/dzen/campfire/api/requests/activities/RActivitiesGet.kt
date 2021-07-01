package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.models.activities.UserActivity
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesGet(
        var userActivityId: Long
) : Request<RActivitiesGet.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        userActivityId = json.m(inp, "userActivityId", userActivityId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var userActivity = UserActivity()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(userActivity:UserActivity) {
            this.userActivity = userActivity
        }

        override fun json(inp: Boolean, json: Json) {
            userActivity = json.m(inp, "userActivity", userActivity)
        }

    }


}
