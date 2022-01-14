package com.dzen.campfire.api.models.publications.moderations.rubrics

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationRubricFandomMove : Moderation {
    var rubricId = 0L
    var rubricName = ""
    var srcFandomId = 0L
    var srcFandomLanguage = 0L
    var srcFandomName = ""
    var destFandomId = 0L
    var destFandomLanguage = 0L
    var destFandomName = ""

    override fun fillResourcesList(list: ArrayList<Long>) {}

    override fun getType(): Long = API.MODERATION_TYPE_RUBRIC_MOVE_FANDOM

    constructor()

    constructor(comment: String,
                rubricId: Long,
                rubricName: String,
                srcFandomId: Long,
                srcFandomLanguage: Long,
                srcFandomName: String,
                destFandomId: Long,
                destFandomLanguage: Long,
                destFandomName: String) : super(comment) {
        this.rubricId = rubricId
        this.rubricName = rubricName
        this.srcFandomId = srcFandomId
        this.srcFandomLanguage = srcFandomLanguage
        this.srcFandomName = srcFandomName
        this.destFandomId = destFandomId
        this.destFandomLanguage = destFandomLanguage
        this.destFandomName = destFandomName
    }

    override fun json(inp: Boolean, json: Json): Json {
        rubricId = json.m(inp, "rubricId", rubricId)
        rubricName = json.m(inp, "rubricName", rubricName)
        srcFandomId = json.m(inp, "srcFandomId", srcFandomId)
        srcFandomLanguage = json.m(inp, "srcFandomLanguage", srcFandomLanguage)
        srcFandomName = json.m(inp, "srcFandomName", srcFandomName)
        destFandomId = json.m(inp, "destFandomId", destFandomId)
        destFandomLanguage = json.m(inp, "destFandomLanguage", destFandomLanguage)
        destFandomName = json.m(inp, "destFandomName", destFandomName)
        return super.json(inp, json)
    }
}