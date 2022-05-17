package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class QuestEffectVibrate : QuestEffect() {
    var times = 1 // 0 = infinite
    var length = 0 // in ms
    var delayStart = 0 // in ms
    var delayBetween = 0 // in ms

    override fun getEffectType(): Long = API.QUEST_EFFECT_TYPE_VIBRATE

    override fun json(inp: Boolean, json: Json): Json {
        times = json.m(inp, "times", times)
        length = json.m(inp, "length", length)
        delayStart = json.m(inp, "delayStart", delayStart)
        delayBetween = json.m(inp, "delayBetween", delayBetween)
        return super.json(inp, json)
    }
}
