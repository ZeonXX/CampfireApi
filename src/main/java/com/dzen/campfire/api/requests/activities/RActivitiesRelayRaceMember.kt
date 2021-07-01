package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesRelayRaceMember(
        var activityId: Long,
        var member: Boolean
) : Request<RActivitiesRelayRaceMember.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        activityId = json.m(inp, "activityId", activityId)
        member = json.m(inp, "member", member)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var myIsCurrentMember = false

        constructor(json: Json) {
            json(false, json)
        }

        constructor(myIsCurrentMember:Boolean) {
            this.myIsCurrentMember = myIsCurrentMember
        }

        override fun json(inp: Boolean, json: Json) {
            myIsCurrentMember = json.m(inp, "myIsCurrentMember", myIsCurrentMember)
        }

    }


}
