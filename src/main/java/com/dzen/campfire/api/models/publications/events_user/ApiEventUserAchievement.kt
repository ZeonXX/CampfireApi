package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ApiEventUserAchievement : ApiEventUser {

    var achievementIndex = 0L
    var achievementLvl = 0L

    override fun getType() = API.PUBLICATION_EVENT_USER_ACHIEVEMENT

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                achievementIndex: Long,
                achievementLvl: Long) : super(
            ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            "") {
        this.achievementIndex = achievementIndex
        this.achievementLvl = achievementLvl
    }

    override fun json(inp: Boolean, json: Json): Json {
        achievementIndex = json.m(inp, "achievementIndex", achievementIndex)
        achievementLvl = json.m(inp, "achievementLvl", achievementLvl)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}