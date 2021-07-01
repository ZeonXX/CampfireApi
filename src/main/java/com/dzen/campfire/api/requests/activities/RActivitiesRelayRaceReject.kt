package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesRelayRaceReject(
        var activityId: Long,
        var nextAccountId: Long
) : Request<RActivitiesRelayRaceReject.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        activityId = json.m(inp, "activityId", activityId)
        nextAccountId = json.m(inp, "nextAccountId", nextAccountId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var currentAccount = Account()
        var currentOwnerTime = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(currentAccount: Account, currentOwnerTime:Long) {
            this.currentAccount = currentAccount
            this.currentOwnerTime = currentOwnerTime
        }

        override fun json(inp: Boolean, json: Json) {
            currentAccount = json.m(inp, "currentAccount", currentAccount)
            currentOwnerTime = json.m(inp, "currentOwnerTime", currentOwnerTime)
        }

    }


}
