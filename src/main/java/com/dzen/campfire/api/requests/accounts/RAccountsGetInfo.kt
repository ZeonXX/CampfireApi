package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.ApiInfo
import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.notifications.Notification
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsGetInfo(
        var languageId:Long
) : Request<RAccountsGetInfo.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var karmaCounts: Array<Long> = emptyArray()
        var fandomsIds: Array<Long> = emptyArray()
        var languagesIds: Array<Long> = emptyArray()
        var notifications: Array<Notification> = emptyArray()
        var chatMessagesCountTags: Array<ChatTag> = emptyArray()
        var viceroyFandomsIds: Array<Long> = emptyArray()
        var viceroyLanguagesIds: Array<Long> = emptyArray()
        var apiInfo = ApiInfo()
        var activitiesCount = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(karmaCounts: Array<Long>,
                    fandomsIds: Array<Long>,
                    languagesIds: Array<Long>,
                    notifications: Array<Notification>,
                    chatMessagesCountTags: Array<ChatTag>,
                    activitiesCount: Long,
                    apiInfo: ApiInfo,
                    viceroyFandomsIds: Array<Long>,
                    viceroyLanguagesIds: Array<Long>) {

            this.karmaCounts = karmaCounts
            this.fandomsIds = fandomsIds
            this.languagesIds = languagesIds
            this.notifications = notifications
            this.chatMessagesCountTags = chatMessagesCountTags
            this.activitiesCount = activitiesCount
            this.apiInfo = apiInfo
            this.viceroyFandomsIds = viceroyFandomsIds
            this.viceroyLanguagesIds = viceroyLanguagesIds
        }

        override fun json(inp: Boolean, json: Json) {
            karmaCounts = json.m(inp, "karmaCounts", karmaCounts)
            languagesIds = json.m(inp, "languagesIds", languagesIds)
            fandomsIds = json.m(inp, "fandomsIds", fandomsIds)
            notifications = json.m(inp, "notifications", notifications, Array<Notification>::class)
            chatMessagesCountTags = json.m(inp, "chatMessagesCountTags", chatMessagesCountTags, Array<ChatTag>::class)
            activitiesCount = json.m(inp, "activitiesCount", activitiesCount)
            apiInfo = json.m(inp, "apiInfo", apiInfo)
            viceroyFandomsIds = json.m(inp, "viceroyFandomsIds", viceroyFandomsIds)
            viceroyLanguagesIds = json.m(inp, "viceroyLanguagesIds", viceroyLanguagesIds)
        }

    }


}
