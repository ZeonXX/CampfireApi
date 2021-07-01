package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectMiniGameAddScore(
        var miniGameScoreHumansAdd:Long,
        var miniGameScoreRobotsAdd:Long
) : Request<RProjectMiniGameAddScore.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        miniGameScoreHumansAdd = json.m(inp, "miniGameScoreHumansAdd", miniGameScoreHumansAdd)
        miniGameScoreRobotsAdd = json.m(inp, "miniGameScoreRobotsAdd", miniGameScoreRobotsAdd)
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
