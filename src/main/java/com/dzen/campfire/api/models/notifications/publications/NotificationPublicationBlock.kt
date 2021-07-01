package com.dzen.campfire.api.models.notifications.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationPublicationBlock : Notification {

    var blockLastPublications = false
    var blockAccountDate = 0L
    var comment = ""
    var moderationId = 0L
    var blockUnitType = 0L
    var tag_s_1 = ""

    constructor()

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor(blockLastPublications: Boolean, blockAccountDate: Long, comment: String, moderationId: Long, blockUnitType: Long, tag_s_1: String) : super(0) {
        this.blockLastPublications = blockLastPublications
        this.blockAccountDate = blockAccountDate
        this.comment = comment
        this.moderationId = moderationId
        this.blockUnitType = blockUnitType
        this.tag_s_1 = tag_s_1
    }

    override fun json(inp: Boolean, json: Json): Json {
        blockLastPublications = json.m(inp, "J_BLOCK_LAST", blockLastPublications)
        blockAccountDate = json.m(inp,  "J_BLOCK_ACCOUNT_DATE", blockAccountDate)
        comment = json.m(inp, "J_COMMENT", comment)
        moderationId = json.m(inp, "J_MODERATION_ID", moderationId)
        blockUnitType = json.m(inp, "blockUnitType", blockUnitType)
        tag_s_1 = json.m(inp, "tag_s_1", tag_s_1)
        return super.json(inp, json)
    }

    override fun getType(): Long {
        return API.NOTIF_PUBLICATION_BLOCK
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}