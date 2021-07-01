package com.dzen.campfire.api.requests.project

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RProjectStatistic : Request<RProjectStatistic.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {

    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var accounts:Array<Long> = emptyArray()
        var posts:Array<Long> = emptyArray()
        var comments:Array<Long> = emptyArray()
        var messages:Array<Long> = emptyArray()
        var enters:Array<Long> = emptyArray()
        var rates:Array<Long> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(accounts:Array<Long>,
                    posts:Array<Long>,
                    comments:Array<Long>,
                    messages:Array<Long>,
                    enters:Array<Long>,
                    rates:Array<Long>
        ) {
            this.accounts = accounts
            this.posts = posts
            this.comments = comments
            this.messages = messages
            this.enters = enters
            this.rates = rates
        }

        override fun json(inp: Boolean, json: Json) {

            this.accounts = json.m(inp, "accounts", accounts)
            this.posts = json.m(inp, "posts", posts)
            this.comments = json.m(inp, "comments", comments)
            this.messages = json.m(inp, "messages", messages)
            this.enters = json.m(inp, "enters", enters)
            this.rates = json.m(inp, "rates", rates)
        }

    }


}