package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesRelayRaceCheckNextUser(
        var activityId: Long,
        var nextAccountId: Long
) : Request<RActivitiesRelayRaceCheckNextUser.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        activityId = json.m(inp, "activityId", activityId)
        nextAccountId = json.m(inp, "nextAccountId", nextAccountId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        constructor(json: Json) {
            json(false, json)
        }

        constructor() {
        }

        override fun json(inp: Boolean, json: Json) {
        }

    }


}
