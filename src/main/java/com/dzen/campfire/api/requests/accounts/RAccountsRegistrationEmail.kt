package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsRegistrationEmail(
        var email:String,
        var password:String,
        var languageId:Long,
        var captchaResp: String,
) : Request<RAccountsRegistrationEmail.Response>() {
    companion object {
        const val E_EMAIL_EXIST = "E_EMAIL_EXIST"
        const val E_CAPTCHA_FAILED = "E_CAPTCHA_FAILED"
    }

    init {
        tokenRequired = false
        tokenDesirable = false
    }

    protected override fun jsonSub(inp: Boolean, json: Json) {
        email = json.m(inp, "email", email)
        password = json.m(inp, "password", password)
        languageId = json.m(inp, "languageId", languageId)
        captchaResp = json.m(inp, "captchaResp", captchaResp)
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
