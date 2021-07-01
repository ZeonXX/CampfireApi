package com.dzen.campfire.api.models.publications.moderations.rubrics

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationRubricCreate : Moderation {

    var rubricId = 0L
    var rubricName = ""
    var ownerId = 0L
    var ownerName = ""

    override fun getType() = API.MODERATION_TYPE_RUBRIC_CREATE

    constructor()

    constructor(comment: String,
                rubricId: Long,
                rubricName: String,
                ownerId: Long,
                ownerName: String
    ) : super(comment) {
        this.rubricId = rubricId
        this.rubricName = rubricName
        this.ownerId = ownerId
        this.ownerName = ownerName
    }

    override fun json(inp: Boolean, json: Json): Json {
        rubricId = json.m(inp, "rubricId", rubricId)
        rubricName = json.m(inp, "rubricName", rubricName)
        ownerId = json.m(inp, "ownerId", ownerId)
        ownerName = json.m(inp, "ownerName", ownerName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
