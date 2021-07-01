package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.activities.UserActivity
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

class PageUserActivity : Page() {

    var userActivity = UserActivity()

    override fun getType() = API.PAGE_TYPE_USER_ACTIVITY

    override fun fillResourcesList(list: ArrayList<Long>) {
    }

    override fun addInsertData(request: Request<*>) {
    }

    override fun restoreInsertData(request: Request<*>, offset:Int):Int {
        return 0
    }

    override fun json(inp: Boolean, json: Json): Json {
        userActivity = json.m(inp, "userActivity", userActivity)
        return super.json(inp, json)
    }

}
