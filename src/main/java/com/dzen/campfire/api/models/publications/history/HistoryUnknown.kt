package com.dzen.campfire.api.models.publications.history

import com.dzen.campfire.api.API

class HistoryUnknown : History() {

    override fun getType() = API.HISTORY_PUBLICATION_TYPE_UNKNOWN

}