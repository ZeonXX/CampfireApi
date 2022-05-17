package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class QuestPartAction : QuestPart() {
    override fun getQuestPartType(): Long = API.QUEST_PART_TYPE_ACTION

    var varId = 0
    var actionType = API.QUEST_ACTION_SET_LITERAL
    var sArg = ""
    var lArg1 = 0
    var lArg2 = 0
    var lArg3 = 0

    // % - as variable, $ - as literal
    // QUEST_ACTION_SET_LITERAL  ->  %lArg1 = $sArg
    // QUEST_ACTION_SET_RANDOM   ->  %lArg1 = random(from = $lArg2, to = $lArg3)
    // QUEST_ACTION_SET_ANOTHER  ->  %lArg1 = %lArg2
    // QUEST_ACTION_ADD_LITERAL  ->  %lArg1 += $lArg2
    // QUEST_ACTION_ADD_ANOTHER  ->  %lArg1 += %lArg2

    override fun json(inp: Boolean, json: Json): Json {
        varId = json.m(inp, "varId", varId)
        actionType = json.m(inp, "actionType", actionType)
        sArg = json.m(inp, "sArg", sArg)
        lArg1 = json.m(inp, "lArg1", lArg1)
        lArg2 = json.m(inp, "lArg2", lArg2)
        lArg3 = json.m(inp, "lArg3", lArg3)
        return super.json(inp, json)
    }
}
