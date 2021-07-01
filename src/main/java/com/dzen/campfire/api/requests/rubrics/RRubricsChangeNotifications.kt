package com.dzen.campfire.api.requests.rubrics

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RRubricsChangeNotifications(
        var rubricId: Long
) : Request<RRubricsChangeNotifications.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        rubricId = json.m(inp, "rubricId", rubricId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var isNotification = false
        var rubricsCount = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(isNotification:Boolean, rubricsCount:Long) {
            this.isNotification = isNotification
            this.rubricsCount = rubricsCount
        }

        override fun json(inp: Boolean, json: Json) {
            isNotification = json.m(inp, "isNotification", isNotification)
            rubricsCount = json.m(inp, "rubricsCount", rubricsCount)
        }

    }

}