package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.models.activities.UserActivity
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesGetAllNotForAccount(
        var accountId:Long,
        var fandomId: Long,
        var languageId: Long,
        var offset:Long
) : Request<RActivitiesGetAllNotForAccount.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var userActivities: Array<UserActivity> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(userActivities: Array<UserActivity>) {
            this.userActivities = userActivities
        }

        override fun json(inp: Boolean, json: Json) {
            userActivities = json.m(inp, "userActivities", userActivities)
        }

    }


}
