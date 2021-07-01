package com.dzen.campfire.api.models.notifications.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationAdminPostRemoveMedia : Notification {

    var postId = 0L
    var postMask = ""
    var comment = ""
    var adminName = ""
    var adminSex = 0L

    constructor()

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_ADMIN_POST_MEDIA_REMOVE

    constructor(postId:Long, postMask:String, adminName: String, adminSex: Long, adminImageId: Long, comment: String) : super(adminImageId) {
        this.postId = postId
        this.postMask = postMask
        this.adminName = adminName
        this.adminSex = adminSex
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        postId = json.m(inp, "postId", postId)
        postMask = json.m(inp, "postMask", postMask)
        comment = json.m(inp, "comment", comment)
        adminName = json.m(inp, "adminName", adminName)
        adminSex = json.m(inp, "adminSex", adminSex)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}