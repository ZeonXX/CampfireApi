package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.models.project.Donate
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectDonatesRatingsGetAllTotal(
        var offset:Long
) : Request<RProjectDonatesRatingsGetAllTotal.Response>() {

    companion object{
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var donates:Array<Donate> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(donates: Array<Donate>) {
            this.donates = donates
        }

        override fun json(inp: Boolean, json: Json) {
            donates = json.m(inp, "donates", donates)
        }

    }

}