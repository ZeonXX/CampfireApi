package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.dzen.campfire.api.API_TRANSLATE
import com.sup.dev.java.libs.json.Json

class QuestPartAction : QuestPart() {
    override fun getQuestPartType(): Long = API.QUEST_PART_TYPE_ACTION

    var varId = 0L
    var actionType = API.QUEST_ACTION_SET_LITERAL
    var sArg = ""
    var lArg1 = 0L
    var lArg2 = 0L
    var jumpId = 0L // -2 = next part, -1 = finish quest

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
        jumpId = json.m(inp, "jumpId", jumpId)
        return super.json(inp, json)
    }

    override fun checkValid(details: QuestDetails, parts: List<QuestPart>, errors: MutableList<QuestException>) {
        assert(errors, details.variablesMap!![varId] != null) {
            QuestException(API_TRANSLATE.quests_edit_error_7)
        }

        var l1 = false
        var l2 = false
        when (actionType) {
            API.QUEST_ACTION_SET_ANOTHER -> { l1 = true }
            API.QUEST_ACTION_ADD_ANOTHER -> { l1 = true }
            API.QUEST_ACTION_SET_ARANDOM -> { l1 = true; l2 = true }
            API.QUEST_ACTION_MULTIPLY    -> { l1 = true }
            API.QUEST_ACTION_DIVIDE      -> { l1 = true }
            API.QUEST_ACTION_BIT_AND     -> { l1 = true }
            API.QUEST_ACTION_BIT_OR      -> { l1 = true }
        }

        if (l1) {
            assert(errors, details.variablesMap!![lArg1] != null) {
                QuestException(API_TRANSLATE.quests_edit_error_7)
            }
        }
        if (l2) {
            assert(errors, details.variablesMap!![lArg2] != null) {
                QuestException(API_TRANSLATE.quests_edit_error_7)
            }
        }

        assert(errors, jumpId < 0 || parts.any { it.id == jumpId }) {
            QuestException(API_TRANSLATE.quests_edit_error_9)
        }
    }
}
