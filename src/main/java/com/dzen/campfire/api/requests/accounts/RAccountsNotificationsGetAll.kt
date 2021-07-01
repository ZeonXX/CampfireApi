package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.notifications.Notification
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RAccountsNotificationsGetAll(
        var offsetDate: Long,
        var filters: Array<Long>,
        var otherEnabled: Boolean
) : Request<RAccountsNotificationsGetAll.Response>() {

    companion object {

        val COUNT = 15
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offsetDate = json.m(inp, "offsetDate", offsetDate)
        filters = json.m(inp, "filters", filters)
        otherEnabled = json.m(inp, "otherEnabled", otherEnabled)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var notifications: Array<Notification> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(notifications: Array<Notification>) {
            this.notifications = notifications
        }

        override fun json(inp: Boolean, json: Json) {
            notifications = json.m(inp, "notifications", notifications, Array<Notification>::class)
        }

    }

}
