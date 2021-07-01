package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.publications.chat.PublicationChatMessage
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RFandomsModerationBlock(
        var publicationId: Long,
        var blockTime: Long,
        var blockLastPublications: Boolean,
        var comment: String,
        var blockInApp: Boolean,
        var userLanguageId: Long
) : Request<RFandomsModerationBlock.Response>() {

    companion object {
        val E_ALREADY = "E_ALREADY"
        val E_DRAFT = "E_DRAFT"
        val E_SELF_PUBLICATION = "E_SELF_PUBLICATION"
        val E_LOW_KARMA_FORCE = "E_LOW_KARMA_FORCE"
        val E_BLOCKS_LIMIT = "E_BLOCKS_LIMIT"
        val E_BLOCKS_REJECTED_STATE = "E_BLOCKS_REJECTED_STATE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        blockTime = json.m(inp, "blockTime", blockTime)
        blockLastPublications = json.m(inp, "blockLastUnits", blockLastPublications)
        comment = json.m(inp, "comment", comment)
        blockInApp = json.m(inp, "blockInApp", blockInApp)
        userLanguageId = json.m(inp, "userLanguageId", userLanguageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var blockedPublicationsIds: Array<Long> = emptyArray()
        var publicationChatMessage: PublicationChatMessage? = null

        constructor(json: Json) {
            json(false, json)
        }

        constructor(blockedPublicationsIds: Array<Long>, unitChatMessage: PublicationChatMessage?) {
            this.blockedPublicationsIds = blockedPublicationsIds
            this.publicationChatMessage = unitChatMessage
        }

        override fun json(inp: Boolean, json: Json) {
            blockedPublicationsIds = json.m(inp, "blockedUnitsIds", blockedPublicationsIds)
            publicationChatMessage = json.mNull(inp, "unitChatMessage", publicationChatMessage, PublicationChatMessage::class)
        }

    }

}
