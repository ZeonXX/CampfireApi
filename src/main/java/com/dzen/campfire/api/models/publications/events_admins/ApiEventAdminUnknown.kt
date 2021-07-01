package com.dzen.campfire.api.models.publications.events_admins


import com.dzen.campfire.api.API

class ApiEventAdminUnknown : ApiEventAdmin {


    constructor()

    override fun getType() = API.PUBLICATION_EVENT_ADMIN_UNKNOWN

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}