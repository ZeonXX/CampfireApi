package com.dzen.campfire.api.models.lvl


abstract class LvlInfo{

    val lvl: Long
    val karmaCount: Long

    constructor(lvl: Long, karmaCount: Long){
        this.lvl = lvl
        this.karmaCount = karmaCount*100
    }

}
