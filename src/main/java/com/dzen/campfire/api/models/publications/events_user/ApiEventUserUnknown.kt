package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API

class ApiEventUserUnknown : ApiEventUser {


    constructor()

    override fun getType() = API.PUBLICATION_EVENT_USER_UNKNOWN

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}