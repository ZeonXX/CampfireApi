package com.dzen.campfire.api.models.publications.moderations.rubrics

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationRubricChangeOwner : Moderation {

    var rubricId = 0L
    var rubricName = ""
    var oldOwnerId = 0L
    var oldOwnerName = ""
    var newOwnerId = 0L
    var newOwnerName = ""

    override fun getType() = API.MODERATION_TYPE_RUBRIC_CHANGE_OWNER

    constructor()

    constructor(comment: String,
                rubricId: Long,
                rubricName: String,
                oldOwnerId: Long,
                oldOwnerName: String,
                newOwnerId: Long,
                newOwnerName: String
    ) : super(comment) {
        this.rubricId = rubricId
        this.rubricName = rubricName
        this.oldOwnerId = oldOwnerId
        this.oldOwnerName = oldOwnerName
        this.newOwnerId = newOwnerId
        this.newOwnerName = newOwnerName
    }

    override fun json(inp: Boolean, json: Json): Json {
        rubricId = json.m(inp, "rubricId", rubricId)
        rubricName = json.m(inp, "rubricName", rubricName)
        oldOwnerId = json.m(inp, "oldOwnerId", oldOwnerId)
        oldOwnerName = json.m(inp, "oldOwnerName", oldOwnerName)
        newOwnerId = json.m(inp, "newOwnerId", newOwnerId)
        newOwnerName = json.m(inp, "newOwnerName", newOwnerName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
