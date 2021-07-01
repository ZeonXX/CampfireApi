package com.dzen.campfire.api.models.notifications.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationPublicationRestore : Notification {

    var publicationId = 0L
    var parentPublicationId = 0L
    var parentPublicationType = 0L
    var publicationType = 0L
    var comment: String = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_PUBLICATION_RESTORE

    constructor() {

    }

    constructor(publicationId:Long, parentPublicationId:Long, parentPublicationType:Long, fandomImageId:Long, comment: String, publicationType: Long) : super(fandomImageId) {
        this.publicationId = publicationId
        this.parentPublicationId = parentPublicationId
        this.parentPublicationType = parentPublicationType
        this.comment = comment
        this.publicationType = publicationType
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "unitId", publicationId)
        parentPublicationId = json.m(inp, "parentUnitId", parentPublicationId)
        parentPublicationType = json.m(inp, "parentPublicationType", parentPublicationType)
        comment = json.m(inp, "comment", comment)
        publicationType = json.m(inp, "unitType", publicationType)
        return super.json(inp, json)
    }


    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
