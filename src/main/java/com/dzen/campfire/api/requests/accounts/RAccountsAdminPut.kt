package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RAccountsAdminPut(var login: String, var googleTokenId: String, var img:ByteArray?) : Request<RAccountsAdminPut.Response>() {

    init {
        tokenRequired = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        login = json.m(inp, "login", login)
        googleTokenId = json.m(inp, "googleTokenId", googleTokenId)
        img = json.mNull(inp, "img", img, ByteArray::class)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var accountId: Long = 0
        var imageId: Long = 0

        constructor(json: Json) {
            json(false, json)
        }

        constructor(accountId: Long, imageId: Long) {
            this.accountId = accountId
            this.imageId = imageId
        }

        override fun json(inp: Boolean, json: Json) {
            accountId = json.m(inp, "accountId", accountId)
            imageId = json.m(inp, "imageId", imageId)
        }

    }


}
