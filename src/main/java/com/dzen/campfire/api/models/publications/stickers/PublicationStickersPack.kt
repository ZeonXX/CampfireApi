package com.dzen.campfire.api.models.publications.stickers

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.Publication
import com.sup.dev.java.libs.json.Json

class PublicationStickersPack : Publication {

    var name = ""
    var imageId = 0L

    override fun getPublicationTypeConst() = API.PUBLICATION_TYPE_STICKERS_PACK

    constructor() {

    }

    constructor(jsonDB: Json) : super(jsonDB) {
        restoreFromJsonDB()
    }

    override fun jsonPublication(inp: Boolean, json: Json) {}

    override fun jsonDBLocal(inp: Boolean, json: Json): Json {
        imageId = json.m(inp, "imageId", imageId)
        name = json.m(inp, "name", name)
        return json
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(imageId)
    }
}