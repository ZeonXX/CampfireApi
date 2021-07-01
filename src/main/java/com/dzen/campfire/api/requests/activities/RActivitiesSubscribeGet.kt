package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesSubscribeGet(
        var activityId: Long
) : Request<RActivitiesSubscribeGet.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        activityId = json.m(inp, "activityId", activityId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var subscribed = false

        constructor(json: Json) {
            json(false, json)
        }

        constructor(subscribed:Boolean) {
            this.subscribed = subscribed
        }

        override fun json(inp: Boolean, json: Json) {
            subscribed = json.m(inp, "subscribed", subscribed)
        }

    }


}
