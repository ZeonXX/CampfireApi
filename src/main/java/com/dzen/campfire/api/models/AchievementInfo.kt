package com.dzen.campfire.api.models


class AchievementInfo {

    val index: Long
    val maxLvl: Int
    val force: Long
    val targets: Array<Int>

    constructor(index:Long, force: Long, vararg targets : Int){
        this.index = index
        this.targets = targets.toTypedArray()
        this.force = force
        maxLvl = targets.size
    }

    fun getTarget(currentLvl: Int): Long {
        return targets[currentLvl].toLong()
    }

    fun getLvl(value: Long): Int {
        for (i in targets.indices.reversed())
            if (value >= targets[i])
                return i + 1
        return 0
    }

    fun getForce(): Double {
        return force / 100.0
    }
}
