package com.dzen.campfire.api.models.fandoms

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class Fandom : JsonParsable {

    var id = 0L
    var name = ""
    var imageId = 0L
    var languageId = 0L
    var closed = false
    var karmaCof = 0L

    var dateCreate = 0L
    var creatorId = 0L
    var subscribesCount = 0L
    var status = 0L
    var category = 0L
    var imageTitleId = 0L
    var imageTitleGifId = 0L

    constructor() {

    }

    constructor(id: Long, languageId: Long, name: String, imageId: Long, closed: Boolean, karmaCof: Long) {
        this.id = id
        this.languageId = languageId
        this.name = name
        this.imageId = imageId
        this.closed = closed
        this.karmaCof = karmaCof
    }

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        name = json.m(inp, "name", name)
        imageId = json.m(inp, "imageId", imageId)
        imageTitleId = json.m(inp, "imageTitleId", imageTitleId)
        imageTitleGifId = json.m(inp, "imageTitleGifId", imageTitleGifId)
        dateCreate = json.m(inp, "dateCreate", dateCreate)
        creatorId = json.m(inp, "creatorId", creatorId)
        subscribesCount = json.m(inp, "subscribesCount", subscribesCount)
        status = json.m(inp, "status", status)
        languageId = json.m(inp, "languageId", languageId)
        category = json.m(inp, "category", category)
        closed = json.m(inp, "closed", closed)
        karmaCof = json.m(inp, "karmaCof", karmaCof)

        return json
    }

    fun copy() : Fandom{
        val json = json(true, Json())
        val copy = Fandom()
        copy.json(false, json)
        return copy
    }


}