package com.dzen.campfire.api.models.publications.moderations

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.Publication
import com.sup.dev.java.libs.json.Json

class PublicationModeration : Publication {

    var moderation: Moderation? = null

    override fun getPublicationTypeConst() = API.PUBLICATION_TYPE_MODERATION

    constructor()

    constructor(jsonDB: Json) : super(jsonDB) {
        restoreFromJsonDB()
    }

    override fun jsonPublication(inp: Boolean, json: Json) {}

    override fun jsonDBLocal(inp: Boolean, json: Json): Json {
        moderation = json.mNull(inp, "moderation", moderation, Moderation::class)
        return json
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        if (moderation != null) moderation!!.fillResourcesList(list)
    }

}
