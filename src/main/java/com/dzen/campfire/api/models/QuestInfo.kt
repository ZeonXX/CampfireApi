package com.dzen.campfire.api.models

class QuestInfo {

    var index: Long
    var targets: Array<Int>
    var story: Boolean

    constructor(index: Long, story:Boolean, vararg targets: Int){
        this.index = index
        this.story = story
        this.targets = targets.toTypedArray()
    }

    fun questIsFinished(accountLvl: Long, value: Long): Boolean {
        return value >= getTarget(accountLvl)
    }

    fun getTarget(accountLvl: Long): Int {
        val lvl = (accountLvl / 100 - 1).toInt()
        return if (targets.size > lvl) targets[lvl] else targets[targets.size - 1]
    }

}
