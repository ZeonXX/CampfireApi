package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesRelayRaceChange(
        var activityId: Long,
        var name: String,
        var description: String,
        var comment: String
) : Request<RActivitiesRelayRaceChange.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        activityId = json.m(inp, "activityId", activityId)
        name = json.m(inp, "name", name)
        description = json.m(inp, "description", description)
        comment = json.m(inp, "comment", comment)
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
