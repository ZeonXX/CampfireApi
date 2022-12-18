package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.models.translate.Translate

class QuestException(
    val translate: Translate,
    vararg val params: String,
    var partId: Long = -1,
) : Exception("[#$partId] ${translate.text.format(*params)}")
