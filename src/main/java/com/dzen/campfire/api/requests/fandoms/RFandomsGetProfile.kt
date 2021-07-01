package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.fandoms.FandomLink
import com.dzen.campfire.api.models.publications.post.PublicationPost
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsGetProfile(
        var fandomId: Long,
        var languageId: Long
) : Request<RFandomsGetProfile.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var viceroyAccount: Account? = null
        var viceroyDate = 0L
        var pinnedPost: PublicationPost? = null
        var subscriptionType = 0L
        var notifyImportant = false
        var imageTitleId = 0L
        var imageTitleGifId = 0L


        constructor(json: Json) {
            json(false, json)
        }

        constructor(viceroyAccount:Account?,
                    viceroyDate:Long,
                    pinnedPost: PublicationPost?,
                    subscriptionType: Long,
                    notifyImportant: Boolean,
                    imageTitleId: Long,
                    imageTitleGifId:Long
        ) {
            this.viceroyAccount = viceroyAccount
            this.viceroyDate = viceroyDate
            this.pinnedPost = pinnedPost
            this.subscriptionType = subscriptionType
            this.notifyImportant = notifyImportant
            this.imageTitleId = imageTitleId
            this.imageTitleGifId = imageTitleGifId
        }

        override fun json(inp: Boolean, json: Json) {
            viceroyAccount = json.mNull(inp, "viceroyAccount", viceroyAccount, Account::class)
            viceroyDate = json.m(inp, "viceroyDate", viceroyDate)
            pinnedPost = json.mNull(inp, "pinnedPost", pinnedPost, PublicationPost::class)
            subscriptionType = json.m(inp, "subscriptionType", subscriptionType)
            notifyImportant = json.m(inp, "notifyImportant", notifyImportant)
            imageTitleId = json.m(inp, "imageTitleId", imageTitleId)
            imageTitleGifId = json.m(inp, "imageTitleGifId", imageTitleGifId)
        }

    }


}