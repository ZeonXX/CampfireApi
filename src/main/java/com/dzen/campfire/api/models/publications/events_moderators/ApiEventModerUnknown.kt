package com.dzen.campfire.api.models.publications.events_moderators

import com.dzen.campfire.api.API

class ApiEventModerUnknown : ApiEventModer {


    constructor()

    override fun getType() = API.PUBLICATION_EVENT_MODER_UNKNOWN

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}