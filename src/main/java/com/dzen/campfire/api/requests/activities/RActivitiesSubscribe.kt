package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesSubscribe(
        var activityId: Long,
        var subscribed: Boolean
) : Request<RActivitiesSubscribe.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        activityId = json.m(inp, "activityId", activityId)
        subscribed = json.m(inp, "subscribed", subscribed)
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
