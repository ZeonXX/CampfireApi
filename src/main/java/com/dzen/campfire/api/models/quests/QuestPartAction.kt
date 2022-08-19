package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class QuestPartAction : QuestPart() {
    override fun getQuestPartType(): Long = API.QUEST_PART_TYPE_ACTION

    var varId = 0L
    var actionType = API.QUEST_ACTION_SET_LITERAL
    var sArg = ""
    var lArg1 = 0L
    var lArg2 = 0L

    // % - as variable, $ - as literal
    // QUEST_ACTION_SET_LITERAL  ->  %varId = $sArg
    // QUEST_ACTION_SET_RANDOM   ->  %varId = random(from = $lArg1, to = $lArg2)
    //  | typeof %varId == bool    -> %varId = randomBool()
    // QUEST_ACTION_SET_ANOTHER  ->  %varId = %lArg1
    // QUEST_ACTION_ADD_LITERAL  ->  %varId += $sArg
    //  | typeof %varId == bool    -> %varId = !%varId
    //  | typeof %varId == text    -> %varId = concat(%varId, $sArg)
    // QUEST_ACTION_ADD_ANOTHER  ->  %varId += %lArg1
    //  | typeof %varId == text    -> %varId = concat(%varId, %lArg1)
    // QUEST_ACTION_SET_ARANDOM  ->  %varId = random(from = %lArg1, to = %lArg2)
    // QUEST_ACTION_MULTIPLY     ->  %varId *= %lArg1
    // QUEST_ACTION_DIVIDE       ->  %varId /= %lArg1
    // QUEST_ACTION_BIT_AND      ->  %varId &= %lArg1
    // QUEST_ACTION_BIT_OR       ->  %varId |= %lArg1

    override fun json(inp: Boolean, json: Json): Json {
        varId = json.m(inp, "varId", varId)
        actionType = json.m(inp, "actionType", actionType)
        sArg = json.m(inp, "sArg", sArg)
        lArg1 = json.m(inp, "lArg1", lArg1)
        lArg2 = json.m(inp, "lArg2", lArg2)
        return super.json(inp, json)
    }
}
