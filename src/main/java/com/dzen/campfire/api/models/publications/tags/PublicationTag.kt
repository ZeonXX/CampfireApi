package com.dzen.campfire.api.models.publications.tags

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.Publication

import com.sup.dev.java.libs.json.Json

class PublicationTag : Publication {

    var name: String = ""
    var imageId: Long = 0

    override fun getPublicationTypeConst() = API.PUBLICATION_TYPE_TAG

    constructor() {

    }

    constructor(jsonDB: Json) : super(jsonDB) {
        restoreFromJsonDB()
    }

    override fun jsonPublication(inp: Boolean, json: Json) {}

    override fun jsonDBLocal(inp: Boolean, json: Json): Json {
        imageId = json.m(inp, "J_IMAGE_ID", imageId)
        name = json.m(inp, "J_NAME", name)
        return json
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(imageId)
    }
}