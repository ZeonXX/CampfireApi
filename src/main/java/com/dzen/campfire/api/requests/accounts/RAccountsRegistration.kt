package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RAccountsRegistration(
        var languageId:Long,
        var image:ByteArray?
) : Request<RAccountsRegistration.Response>() {

    companion object {

        val E_IMAGE_SCALE = "E_IMAGE_SCALE"
        val E_IMAGE_WEIGHT = "E_IMAGE_WEIGHT"
        val E_GOOGLE_ID_EXIST = "E_GOOGLE_ID_EXIST"
    }

    init {
        tokenRequired = false
        tokenDesirable = true
        addDataOutput(image)
    }

    protected override fun jsonSub(inp: Boolean, json: Json) {
        languageId = json.m(inp, "languageId", languageId)
        image  = dataOutput[0]
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
