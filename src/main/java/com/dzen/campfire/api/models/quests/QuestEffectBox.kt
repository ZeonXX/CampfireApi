package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class QuestEffectBox : QuestEffect() {
    var box = API.LINK_BOX_WITH_BOX

    override fun getEffectType(): Long = API.QUEST_EFFECT_TYPE_BOX

    override fun json(inp: Boolean, json: Json): Json {
        box = API.LINKS_ARRAY.find { it.link == json.m(inp, "box", box.link) } ?: API.LINK_BOX_WITH_BOX
        return super.json(inp, json)
    }
}
