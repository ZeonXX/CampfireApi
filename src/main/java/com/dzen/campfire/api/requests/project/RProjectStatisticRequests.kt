package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.models.project.StatisticRequest
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectStatisticRequests(
    var sort:Long,
    var offset:Long
) : Request<RProjectStatisticRequests.Response>() {

    companion object {
        val SORT_AVG = 1L
        val SORT_MAX = 2L
        val SORT_TOTAL = 3L
        val SORT_COUNT = 4L
        val COUNT = 20
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        sort = json.m(inp, "sort", sort)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var statistic:Array<StatisticRequest> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(statistic: Array<StatisticRequest>) {
            this.statistic = statistic
        }

        override fun json(inp: Boolean, json: Json) {
            statistic = json.m(inp, "statistic", statistic)
        }

    }

}