package com.dzen.campfire.api.models.publications.moderations.rubrics

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationRubricChangeName : Moderation {

    var rubricId = 0L
    var rubricOldName = ""
    var rubricNewName = ""

    override fun getType() = API.MODERATION_TYPE_RUBRIC_CHANGE_NAME

    constructor()

    constructor(comment: String,
                rubricId: Long,
                rubricOldName: String,
                rubricNewName: String
    ) : super(comment) {
        this.rubricId = rubricId
        this.rubricOldName = rubricOldName
        this.rubricNewName = rubricNewName
    }

    override fun json(inp: Boolean, json: Json): Json {
        rubricId = json.m(inp, "rubricId", rubricId)
        rubricOldName = json.m(inp, "rubricOldName", rubricOldName)
        rubricNewName = json.m(inp, "rubricNewName", rubricNewName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
