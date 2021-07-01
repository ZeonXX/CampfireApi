package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectMiniGameGetinfo() : Request<RProjectMiniGameGetinfo.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var miniGameScoreHumans = 0L
        var miniGameScoreRobots = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(miniGameScoreHumans: Long,
                    miniGameScoreRobots: Long) {

            this.miniGameScoreHumans = miniGameScoreHumans
            this.miniGameScoreRobots = miniGameScoreRobots
        }

        override fun json(inp: Boolean, json: Json) {
            miniGameScoreHumans = json.m(inp, "miniGameScoreHumans", miniGameScoreHumans)
            miniGameScoreRobots = json.m(inp, "miniGameScoreRobots", miniGameScoreRobots)
        }

    }


}


