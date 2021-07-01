package com.dzen.campfire.api.models.publications.moderations.rubrics

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationRubricRemove : Moderation {

    var rubricId = 0L
    var rubricName = ""

    override fun getType() = API.MODERATION_TYPE_RUBRIC_REMOVE

    constructor()

    constructor(comment: String,
                rubricId: Long,
                rubricName: String
    ) : super(comment) {
        this.rubricId = rubricId
        this.rubricName = rubricName
    }

    override fun json(inp: Boolean, json: Json): Json {
        rubricId = json.m(inp, "rubricId", rubricId)
        rubricName = json.m(inp, "rubricName", rubricName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
