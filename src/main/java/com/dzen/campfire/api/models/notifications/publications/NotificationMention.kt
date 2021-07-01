package com.dzen.campfire.api.models.notifications.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationMention : Notification {

    var publicationId = 0L
    var publicationType = 0L
    var tag1 = 0L
    var tag2 = 0L
    var tag3 = 0L
    var fromAccountId = 0L
    var fromAccountImageId = 0L
    var fromAccountName = ""
    var fromAccountSex = 0L
    var text = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_MENTION

    constructor()

    constructor(publicationId: Long,
                publicationType: Long,
                tag1: Long,
                tag2: Long,
                tag3: Long,
                fromAccountId: Long,
                fromAccountImageId: Long,
                fromAccountName: String,
                fromAccountSex: Long,
                text: String) : super(fromAccountImageId) {
        this.publicationId = publicationId
        this.publicationType = publicationType
        this.tag1 = tag1
        this.tag2 = tag2
        this.tag3 = tag3
        this.fromAccountId = fromAccountId
        this.fromAccountImageId = fromAccountImageId
        this.fromAccountName = fromAccountName
        this.fromAccountSex = fromAccountSex
        this.text = text
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "unitId", publicationId)
        publicationType = json.m(inp, "unitType", publicationType)
        tag1 = json.m(inp, "tag1", tag1)
        tag2 = json.m(inp, "tag2", tag2)
        tag3 = json.m(inp, "tag3", tag3)
        fromAccountId = json.m(inp, "fromAccountId", fromAccountId)
        fromAccountImageId = json.m(inp, "fromAccountImageId", fromAccountImageId)
        fromAccountName = json.m(inp, "fromAccountName", fromAccountName)
        fromAccountSex = json.m(inp, "fromAccountSex", fromAccountSex)
        text = json.m(inp, "text", text)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
