package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RAccountsNotificationsView(
        var notificationIds:Array<Long>,
        var notificationTypes:Array<Long>
) : Request<RAccountsNotificationsView.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        notificationIds = json.m(inp, "notificationIds", notificationIds)
        notificationTypes = json.m(inp, "notificationTypes", notificationTypes)
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
