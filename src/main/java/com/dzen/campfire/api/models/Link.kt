package com.dzen.campfire.api.models

import com.dzen.campfire.api.API

class Link(val link: String, val isInnerLink: Boolean = false) {

    fun asLink() = "@$link" + (if (isInnerLink) "" else "_")

    fun asWeb() = "${API.DOMEN}$link-"

    fun asWebOld() = "${API.DOMEN_OLD}$link-"

}