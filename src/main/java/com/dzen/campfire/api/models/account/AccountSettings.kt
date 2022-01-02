package com.dzen.campfire.api.models.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.BookmarksFolder
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class AccountSettings() : JsonParsable {

    //  Style
    var styleNewYearAvatars = true
    var styleNewYearProfileAnimation = true
    var styleNewYearSnow = 100
    var styleSquare = true
    var styleCorned = 10
    var fandomBackground = true
    var styleChatCorned = 8
    var theme = 0
    var interfaceType = 0
    var fullscreen = false
    var isProfileListStyle = false
    //  App
    var watchPost = false
    var appLanguage = ""
    var longPlusFandomId = API.FANDOM_CAMPFIRE_ANYTHING_ID
    var longPlusFandomLanguageId = 0L
    var longPlusFandomName = "Anything"
    var fastPublicationFandomId = API.FANDOM_CAMPFIRE_ANYTHING_ID
    var fastPublicationFandomLanguageId = 0L
    var fastPublicationFandomName = "Anything"
    var voiceMessagesAutoSend = false
    var voiceMessagesAutoLock = false
    var voiceMessagesIgnore = false
    var helloIsShowed = false
    var helloShortIsShowed = false
    var rulesIsShowed = false
    var anonRates = false
    var viewedChats: Array<Long> = emptyArray()
    var storyQuestIndex = 0L
    var storyQuestProgress = 0L
    //  Notifications Settings
    var notifications = true
    var autoReadNotifications = false
    var salientTime = 0L
    var notificationsComments = true
    var notificationsCommentsAnswers = true
    var notificationsKarma = true
    var notificationsOther = true
    var notificationsFollows = true
    var notificationsImportant = true
    var notificationsFollowsPosts = true
    var notificationsAchievements = true
    var notificationsChatMessages = true
    var notificationsChatAnswers = true
    var notificationsPM = true
    var notificationsSalientOnTimeStartH = 23
    var notificationsSalientOnTimeStartM = 0
    var notificationsSalientOnTimeEndH = 8
    var notificationsSalientOnTimeEndM = 0
    var notificationsSalientAll = false
    var notificationsSalientOnTimeEnabled = true
    var userActivitiesAutoSubscribe = true
    var userActivitiesAllowed_all = true
    var userActivitiesAllowed_followedFandoms = true
    var userActivitiesAllowed_followedUsers = true
    //  Feed
    var feedLanguages: Array<Long> = emptyArray()
    var feedCategories: Array<Long> =  emptyArray()
    var feedImportant = false
    var feedOrder: Array<Long> =  emptyArray()
    //  Profile
    var profileFilterEvents = true
    var profileFilterPosts = true
    var profileFilterComments = true
    var profileFilterModerations = true
    var profileFilterChatMessages = false
    var profileFilterStickers = true
    var lvlDialogLvl = 1L
    //  Notifications
    var notificationsFilterFollowsPublications = true
    var notificationsFilterFollows = true
    var notificationsFilterAchievements = true
    var notificationsFilterComments = true
    var notificationsFilterKarma = true
    var notificationsFilterAnswers = true
    var notificationsFilterImportant = true
    var notificationsFilterOther = true
    //  Fandom
    var fandomFilterModerationsPosts = true
    var fandomFilterOnlyImportant = false
    var fandomFilterAdministrations = true
    var fandomFilterModerations = true
    var fandomFilterModerationsBlocks = true
    var fandomNSFW: Array<Long> =  emptyArray()
    //  Admin
    var adminReportsLanguages: Array<Long> = emptyArray()
    //  Bookmarks
    var bookmarksFolders: Array<BookmarksFolder> = emptyArray()
    //  Chats
    var allowAddingToConferences = true

    var isStub = false

    constructor(json:String) : this(){
        json(false, Json(json))
    }

    constructor(json:Json) : this(){
        json(false, json)
    }

    override fun json(inp: Boolean, json: Json): Json {
        styleNewYearAvatars = json.m(inp, "styleNewYearAvatars", styleNewYearAvatars)
        styleSquare = json.m(inp, "styleSquare", styleSquare)
        styleCorned = json.m(inp, "styleCorned", styleCorned)
        fandomBackground = json.m(inp, "fandomBackground", fandomBackground)
        styleChatCorned = json.m(inp, "styleChatCorned", styleChatCorned)
        theme = json.m(inp, "theme", theme)
        interfaceType = json.m(inp, "interfaceType", interfaceType)
        fullscreen = json.m(inp, "fullscreen", fullscreen)
        isProfileListStyle = json.m(inp, "isProfileListStyle", isProfileListStyle)

        watchPost = json.m(inp, "watchPost", watchPost)
        appLanguage = json.m(inp, "appLanguage", appLanguage)
        longPlusFandomId = json.m(inp, "longPlusFandomId", longPlusFandomId)
        longPlusFandomLanguageId = json.m(inp, "longPlusFandomLanguageId", longPlusFandomLanguageId)
        longPlusFandomName = json.m(inp, "longPlusFandomName", longPlusFandomName)
        fastPublicationFandomId = json.m(inp, "fastPublicationFandomId", fastPublicationFandomId)
        fastPublicationFandomLanguageId = json.m(inp, "fastPublicationFandomLanguageId", fastPublicationFandomLanguageId)
        fastPublicationFandomName = json.m(inp, "fastPublicationFandomName", fastPublicationFandomName)
        voiceMessagesAutoSend = json.m(inp, "voiceMessagesAutoSend", voiceMessagesAutoSend)
        voiceMessagesAutoLock = json.m(inp, "voiceMessagesAutoLock", voiceMessagesAutoLock)
        voiceMessagesIgnore = json.m(inp, "voiceMessagesIgnore", voiceMessagesIgnore)
        helloIsShowed = json.m(inp, "helloIsShowed", helloIsShowed)
        helloShortIsShowed = json.m(inp, "helloShortIsShowed", helloShortIsShowed)
        rulesIsShowed = json.m(inp, "rulesIsShowed", rulesIsShowed)
        anonRates = json.m(inp, "anonRates", anonRates)
        viewedChats = json.m(inp, "viewedChats", viewedChats)
        storyQuestIndex = json.m(inp, "storyQuestIndex", storyQuestIndex)
        storyQuestProgress = json.m(inp, "storyQuestProgress", storyQuestProgress)

        notifications = json.m(inp, "notifications", notifications)
        autoReadNotifications = json.m(inp, "autoReadNotifications", autoReadNotifications)
        salientTime = json.m(inp, "salientTime", salientTime)
        notificationsComments = json.m(inp, "notificationsComments", notificationsComments)
        notificationsCommentsAnswers = json.m(inp, "notificationsCommentsAnswers", notificationsCommentsAnswers)
        notificationsKarma = json.m(inp, "notificationsKarma", notificationsKarma)
        notificationsOther = json.m(inp, "notificationsOther", notificationsOther)
        notificationsFollows = json.m(inp, "notificationsFollows", notificationsFollows)
        notificationsImportant = json.m(inp, "notificationsImportant", notificationsImportant)
        notificationsFollowsPosts = json.m(inp, "notificationsFollowsPosts", notificationsFollowsPosts)
        notificationsAchievements = json.m(inp, "notificationsAchievements", notificationsAchievements)
        notificationsChatMessages = json.m(inp, "notificationsChatMessages", notificationsChatMessages)
        notificationsChatAnswers = json.m(inp, "notificationsChatAnswers", notificationsChatAnswers)
        notificationsPM = json.m(inp, "notificationsPM", notificationsPM)
        notificationsSalientOnTimeStartH = json.m(inp, "notificationsSalientOnTimeStartH", notificationsSalientOnTimeStartH)
        notificationsSalientOnTimeStartM = json.m(inp, "notificationsSalientOnTimeStartM", notificationsSalientOnTimeStartM)
        notificationsSalientOnTimeEndH = json.m(inp, "notificationsSalientOnTimeEndH", notificationsSalientOnTimeEndH)
        notificationsSalientOnTimeEndM = json.m(inp, "notificationsSalientOnTimeEndM", notificationsSalientOnTimeEndM)
        notificationsSalientOnTimeEnabled = json.m(inp, "notificationsSalientOnTimeEnabled", notificationsSalientOnTimeEnabled)
        notificationsSalientAll = json.m(inp, "notificationsSalientAll", notificationsSalientAll)
        userActivitiesAutoSubscribe = json.m(inp, "userActivitiesAutoSubscribe", userActivitiesAutoSubscribe)
        userActivitiesAllowed_all = json.m(inp, "userActivitiesAllowed_all", userActivitiesAllowed_all)
        userActivitiesAllowed_followedFandoms = json.m(inp, "userActivitiesAllowed_followedFandoms", userActivitiesAllowed_followedFandoms)
        userActivitiesAllowed_followedUsers = json.m(inp, "userActivitiesAllowed_followedUsers", userActivitiesAllowed_followedUsers)

        feedLanguages = json.m(inp, "feedLanguages", feedLanguages)
        feedCategories = json.m(inp, "feedCategories", feedCategories)
        feedImportant = json.m(inp, "feedImportant", feedImportant)
        feedOrder = json.m(inp, "feedOrder_v2", feedOrder)

        profileFilterEvents = json.m(inp, "profileFilterEvents", profileFilterEvents)
        profileFilterPosts = json.m(inp, "profileFilterPosts", profileFilterPosts)
        profileFilterModerations = json.m(inp, "profileFilterModerations", profileFilterModerations)
        profileFilterComments = json.m(inp, "profileFilterComments", profileFilterComments)
        profileFilterChatMessages = json.m(inp, "profileFilterChatMessages", profileFilterChatMessages)
        profileFilterStickers = json.m(inp, "profileFilterStickers", profileFilterStickers)
        lvlDialogLvl = json.m(inp, "lvlDialogLvl", lvlDialogLvl)

        notificationsFilterFollowsPublications = json.m(inp, "notificationsFilterFollowsPublications", notificationsFilterFollowsPublications)
        notificationsFilterFollows = json.m(inp, "notificationsFilterFollows", notificationsFilterFollows)
        notificationsFilterAchievements = json.m(inp, "notificationsFilterAchievements", notificationsFilterAchievements)
        notificationsFilterComments = json.m(inp, "notificationsFilterComments", notificationsFilterComments)
        notificationsFilterKarma = json.m(inp, "notificationsFilterKarma", notificationsFilterKarma)
        notificationsFilterAnswers = json.m(inp, "notificationsFilterAnswers", notificationsFilterAnswers)
        notificationsFilterImportant = json.m(inp, "notificationsFilterImportant", notificationsFilterImportant)
        notificationsFilterOther = json.m(inp, "notificationsFilterOther", notificationsFilterOther)

        fandomFilterModerationsPosts = json.m(inp, "fandomFilterModerationsPosts", fandomFilterModerationsPosts)
        fandomFilterOnlyImportant = json.m(inp, "fandomFilterOnlyImportant", fandomFilterOnlyImportant)
        fandomFilterAdministrations = json.m(inp, "fandomFilterAdministrations", fandomFilterAdministrations)
        fandomFilterModerations = json.m(inp, "fandomFilterModerations", fandomFilterModerations)
        fandomFilterModerationsBlocks = json.m(inp, "fandomFilterModerationsBlocks", fandomFilterModerationsBlocks)
        fandomNSFW = json.m(inp, "fandomNSFW", fandomNSFW)

        adminReportsLanguages = json.m(inp, "adminReportsLanguages", adminReportsLanguages)

        bookmarksFolders = json.m(inp, "bookmarksFolders", bookmarksFolders)

        allowAddingToConferences = json.m(inp, "allowAddingToConferences", allowAddingToConferences)

        isStub = json.m(inp, "isStub", isStub)

        return json
    }

}