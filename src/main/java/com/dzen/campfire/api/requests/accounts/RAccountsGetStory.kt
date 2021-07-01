package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsGetStory(
        var accountId: Long
) : Request<RAccountsGetStory.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var totalKarmaPlus = 0L
        var totalKarmaMinus = 0L
        var totalRatesPlus = 0L
        var totalRatesMinus = 0L

        var totalComments = 0L
        var totalPosts = 0L
        var totalMessages = 0L

        var bestPost = 0L
        var bestComment = 0L
        var bestCommentUnitType = 0L
        var bestCommentUnitId = 0L


        constructor(json: Json) {
            json(false, json)
        }

        constructor(totalKarmaPlus: Long,
                    totalKarmaMinus: Long,
                    totalRatesPlus: Long,
                    totalRatesMinus: Long,
                    totalComments: Long,
                    totalPosts: Long,
                    totalMessages: Long,
                    bestPost: Long,
                    bestComment: Long,
                    bestCommentUnitType: Long,
                    bestCommentUnitId: Long) {
            this.totalKarmaPlus = totalKarmaPlus
            this.totalKarmaMinus = totalKarmaMinus
            this.totalRatesPlus = totalRatesPlus
            this.totalRatesMinus = totalRatesMinus
            this.totalComments = totalComments
            this.totalPosts = totalPosts
            this.totalMessages = totalMessages
            this.bestPost = bestPost
            this.bestComment = bestComment
            this.bestCommentUnitType = bestCommentUnitType
            this.bestCommentUnitId = bestCommentUnitId
        }

        override fun json(inp: Boolean, json: Json) {
            totalKarmaPlus = json.m(inp, "totalKarmaPlus", totalKarmaPlus)
            totalKarmaMinus = json.m(inp, "totalKarmaMinus", totalKarmaMinus)
            totalRatesPlus = json.m(inp, "totalRatesPlus", totalRatesPlus)
            totalRatesMinus = json.m(inp, "totalRatesMinus", totalRatesMinus)
            totalComments = json.m(inp, "totalComments", totalComments)
            totalPosts = json.m(inp, "totalPosts", totalPosts)
            totalMessages = json.m(inp, "totalMessages", totalMessages)
            bestPost = json.m(inp, "bestPost", bestPost)
            bestComment = json.m(inp, "bestComment", bestComment)
            bestCommentUnitType = json.m(inp, "bestCommentUnitType", bestCommentUnitType)
            bestCommentUnitId = json.m(inp, "bestCommentUnitId", bestCommentUnitId)
        }

    }


}