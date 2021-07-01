package com.dzen.campfire.api.models.publications

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class PublicationUnknown : Publication {

    override fun getPublicationTypeConst() = API.PUBLICATION_TYPE_UNKNOWN

    constructor()

    constructor(jsonDB: Json) : super(jsonDB) {
        restoreFromJsonDB()
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
    }

    override fun jsonPublication(inp: Boolean, json: Json) {
    }

}