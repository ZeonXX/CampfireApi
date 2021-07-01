package com.dzen.campfire.api.requests.activities

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RActivitiesGetCounts(
        var languagesIds: Array<Long>
) : Request<RActivitiesGetCounts.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        languagesIds = json.m(inp, "languagesIds", languagesIds)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {


        var relayRacesCount = 0L
        var rubricsCount = 0L
        var suggestedFandomsCount = 0L
        var reportsCount = 0L
        var reportsUserCount = 0L
        var blocksCount = 0L
        var translateModerationCount = 0L
        var adminVoteCount = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(relayRacesCount: Long,
                    rubricsCount: Long,
                    suggestedFandomsCount: Long,
                    reportsCount: Long,
                    reportsUserCount: Long,
                    blocksCount: Long,
                    translateModerationCount: Long,
                    adminVoteCount: Long) {
            this.relayRacesCount = relayRacesCount
            this.rubricsCount = rubricsCount
            this.suggestedFandomsCount = suggestedFandomsCount
            this.reportsCount = reportsCount
            this.reportsUserCount = reportsUserCount
            this.blocksCount = blocksCount
            this.translateModerationCount = translateModerationCount
            this.adminVoteCount = adminVoteCount
        }

        override fun json(inp: Boolean, json: Json) {
            relayRacesCount = json.m(inp, "relayRacesCount", relayRacesCount)
            rubricsCount = json.m(inp, "rubricsCount", rubricsCount)
            suggestedFandomsCount = json.m(inp, "suggestedFandomsCount", suggestedFandomsCount)
            reportsCount = json.m(inp, "reportsCount", reportsCount)
            reportsUserCount = json.m(inp, "reportsUserCount", reportsUserCount)
            blocksCount = json.m(inp, "blocksCount", blocksCount)
            translateModerationCount = json.m(inp, "translateModerationCount", translateModerationCount)
            adminVoteCount = json.m(inp, "adminVoteCount", adminVoteCount)
        }

    }


}
