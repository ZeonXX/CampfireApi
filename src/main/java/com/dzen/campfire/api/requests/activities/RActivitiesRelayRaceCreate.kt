package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.models.activities.UserActivity
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesRelayRaceCreate(
        var accountId: Long,
        var fandomId: Long,
        var languageId: Long,
        var name: String,
        var description: String,
        var comment: String
) : Request<RActivitiesRelayRaceCreate.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        name = json.m(inp, "name", name)
        description = json.m(inp, "description", description)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var userActivity = UserActivity()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(userActivity: UserActivity) {
            this.userActivity = userActivity
        }

        override fun json(inp: Boolean, json: Json) {
            userActivity = json.m(inp, "userActivity", userActivity)
        }

    }


}
