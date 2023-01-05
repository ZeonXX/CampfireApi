package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.AccountLinks
import com.dzen.campfire.api.models.account.MAccountEffect
import com.dzen.campfire.api.models.publications.post.PublicationPost
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsGetProfile(var accountId: Long, var accountName: String) : Request<RAccountsGetProfile.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        accountName = json.m(inp, "accountName", accountName)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var dateCreate = 0L
        var pinnedPost:PublicationPost? = null
        var banDate = 0L
        var status = ""
        var note = ""
        var isFollow = false
        var followsYou = false
        var followsCount = 0L
        var followersCount = 0L
        var age = 0L
        var description = ""
        var links = AccountLinks()
        var titleImageId = 0L
        var titleImageGifId = 0L
        var bansCount = 0L
        var warnsCount = 0L
        var karmaTotal = 0L
        var rates = 0L
        var moderationFandomsCount = 0L
        var subscribedFandomsCount = 0L
        var stickersCount = 0L
        var blackAccountsCount = 0L
        var blackFandomsCount = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(dateCreate: Long,
                    banDate: Long,
                    titleImageId: Long,
                    titleImageGifId: Long,
                    isFollow: Boolean,
                    followsYou: Boolean,
                    followsCount: Long,
                    followersCount: Long,
                    status: String,
                    age: Long,
                    description: String,
                    links: AccountLinks,
                    note: String,
                    pinnedPost: PublicationPost?,
                    bansCount: Long,
                    warnsCount: Long,
                    karmaTotal: Long,
                    rates: Long,
                    moderationFandomsCount: Long,
                    subscribedFandomsCount: Long,
                    stickersCount: Long,
                    blackAccountsCount: Long,
                    blackFandomsCount: Long
        ) {
            this.dateCreate = dateCreate
            this.banDate = banDate
            this.titleImageId = titleImageId
            this.titleImageGifId = titleImageGifId
            this.isFollow = isFollow
            this.followsYou = followsYou
            this.followsCount = followsCount
            this.followersCount = followersCount
            this.status = status
            this.age = age
            this.description = description
            this.links = links
            this.note = note
            this.pinnedPost = pinnedPost
            this.bansCount = bansCount
            this.warnsCount = warnsCount
            this.karmaTotal = karmaTotal
            this.rates = rates
            this.moderationFandomsCount = moderationFandomsCount
            this.subscribedFandomsCount = subscribedFandomsCount
            this.stickersCount = stickersCount
            this.blackAccountsCount = blackAccountsCount
            this.blackFandomsCount = blackFandomsCount
        }

        override fun json(inp: Boolean, json: Json) {
            dateCreate = json.m(inp, "dateCreate", dateCreate)
            banDate = json.m(inp, "banDate", banDate)
            titleImageId = json.m(inp, "titleImageId", titleImageId)
            titleImageGifId = json.m(inp, "titleImageGifId", titleImageGifId)
            isFollow = json.m(inp, "isFollow", isFollow)
            followsYou = json.m(inp, "followsYou", followsYou)
            followsCount = json.m(inp, "followsCount", followsCount)
            followersCount = json.m(inp, "followersCount", followersCount)
            status = json.m(inp, "status", status)
            age = json.m(inp, "age", age)
            description = json.m(inp, "description", description)
            links = json.m(inp, "links", links, AccountLinks::class)
            note = json.m(inp, "note", note)
            pinnedPost = json.mNull(inp, "pinnedPost", pinnedPost, PublicationPost::class)
            bansCount = json.m(inp, "bansCount", bansCount)
            warnsCount = json.m(inp, "warnsCount", warnsCount)
            karmaTotal = json.m(inp, "karmaTotal", karmaTotal)
            rates = json.m(inp, "rates", rates)
            moderationFandomsCount = json.m(inp, "moderationFandomsCount", moderationFandomsCount)
            subscribedFandomsCount = json.m(inp, "subscribedFandomsCount", subscribedFandomsCount)
            stickersCount = json.m(inp, "stickersCount", stickersCount)
            blackAccountsCount = json.m(inp, "blackAccountsCount", blackAccountsCount)
            blackFandomsCount = json.m(inp, "blackFandomsCount", blackFandomsCount)
        }

    }


}