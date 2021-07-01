package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.models.activities.UserActivity
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesGetRelayRaceFullInfo(
        var userActivityId: Long
) : Request<RActivitiesGetRelayRaceFullInfo.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        userActivityId = json.m(inp, "userActivityId", userActivityId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var userActivity = UserActivity()
        var postsCount = 0L
        var waitMembersCount = 0L
        var rejectedMembersCount = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(userActivity:UserActivity, postsCount:Long, waitMembersCount:Long, rejectedMembersCount:Long) {
            this.userActivity = userActivity
            this.postsCount = postsCount
            this.waitMembersCount = waitMembersCount
            this.rejectedMembersCount = rejectedMembersCount
        }

        override fun json(inp: Boolean, json: Json) {
            userActivity = json.m(inp, "userActivity", userActivity)
            postsCount = json.m(inp, "postsCount", postsCount)
            waitMembersCount = json.m(inp, "waitMembersCount", waitMembersCount)
            rejectedMembersCount = json.m(inp, "rejectedMembersCount", rejectedMembersCount)
        }

    }


}
