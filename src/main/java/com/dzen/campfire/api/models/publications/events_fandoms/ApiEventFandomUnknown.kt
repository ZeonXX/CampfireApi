package com.dzen.campfire.api.models.publications.events_fandoms

import com.dzen.campfire.api.API

class ApiEventFandomUnknown : ApiEventFandom {

    constructor()

    override fun getType() = API.PUBLICATION_EVENT_FANDOM_UNKNOWN

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}