package com.dzen.campfire.api.models

import com.dzen.campfire.api.API
import com.sup.dev.java.tools.ToolsText

class LinkParsed(
        val linkRaw: String
) {

    var link = ""
    var params: List<String> = emptyList()

    init {
        if (linkRaw.startsWith("@")) {
            val s1 = linkRaw.split("_")
            link = s1[0] + "_"
            params = if (s1.size > 1) s1.subList(1, s1.size) else emptyList()
        } else {
            if (linkRaw.length > API.DOMEN.length) {
                val t = linkRaw.substring(API.DOMEN.length)
                val s1 = t.split("-")
                link = s1[0]
                params = if (s1.size > 1) s1[1].split("_") else emptyList()
            }
        }
    }

    fun getLongParamOrZero(index: Int): Long {
        try {
            return params[index].toLong()
        } catch (e: Exception) {
            return 0L
        }
    }

    fun isValid() = isLinkToAccount() || isLinkToPost() || isLinkToChat() || isLinkToFandom() || isLinkToStickersPack()|| isLinkToComment()

    fun isLinkToAccount(): Boolean {
        if (link == API.LINK_PROFILE_ID.asLink()) return params.size == 1
        if (link == API.LINK_TAG_PROFILE_NAME) return params.size == 1
        if (link.startsWith(API.LINK_SHORT_PROFILE) && params.isEmpty() && ToolsText.isOnly(link.substring(1, link.length - 1), ToolsText.LATIS_S + ToolsText.NUMBERS_S)) {
            return true
        }
        return false
    }

    fun isLinkToPost(): Boolean {
        if (link == API.LINK_POST.asLink()) return params.size == 1
        if (link == API.LINK_POST.link) return params.size == 1
        return false
    }

    fun isLinkToComment(): Boolean {
        if (link == API.LINK_POST.asLink()) return params.size == 2
        if (link == API.LINK_POST.link) return params.size == 2
        if (link == API.LINK_MODERATION.asLink()) return params.size == 2
        if (link == API.LINK_MODERATION.link) return params.size == 2
        if (link == API.LINK_STICKERS_PACK.asLink()) return params.size == 2
        if (link == API.LINK_STICKERS_PACK.link) return params.size == 2
        return false
    }

    fun isLinkToChat(): Boolean {
        if (link == API.LINK_CHAT.asLink()) return params.size in 1..2
        if (link == API.LINK_CHAT.link) return params.size in 1..2
        return false
    }

    fun isLinkToConf(): Boolean {
        if (link == API.LINK_CONF.asLink()) return params.size in 1..2
        if (link == API.LINK_CONF.link) return params.size in 1..2
        return false
    }

    fun isLinkToWikiFandom(): Boolean {
        if (link == API.LINK_WIKI_FANDOM.asLink()) return params.size == 1
        if (link == API.LINK_WIKI_FANDOM.link) return params.size == 1
        return false
    }

    fun isLinkToWikiSection(): Boolean {
        if (link == API.LINK_WIKI_SECTION.asLink()) return params.size == 1
        if (link == API.LINK_WIKI_SECTION.link) return params.size == 1
        return false
    }

    fun isLinkToWikiArticle(): Boolean {
        if (link == API.LINK_WIKI_ARTICLE.asLink()) return params.size == 1
        if (link == API.LINK_WIKI_ARTICLE.link) return params.size == 1
        return false
    }

    fun isLinkToFandomChat(): Boolean {
        if (link == API.LINK_FANDOM_CHAT.asLink()) return params.size == 1
        if (link == API.LINK_FANDOM_CHAT.link) return params.size == 1
        return false
    }

    fun isLinkToActivity(): Boolean {
        if (link == API.LINK_ACTIVITY.asLink()) return params.size == 1
        if (link == API.LINK_ACTIVITY.link) return params.size == 1
        return false
    }

    fun isLinkToRubric(): Boolean {
        if (link == API.LINK_RUBRIC.asLink()) return params.size == 1
        if (link == API.LINK_RUBRIC.link) return params.size == 1
        return false
    }

    fun isLinkToFandom(): Boolean {
        if (link == API.LINK_FANDOM.asLink()) return params.size in 1..2
        if (link == API.LINK_FANDOM.link) return params.size in 1..2
        return false
    }

    fun isLinkToStickersPack(): Boolean {
        if (link == API.LINK_STICKERS_PACK.asLink()) return params.size == 1
        if (link == API.LINK_STICKERS_PACK.link) return params.size == 1
        return false
    }

}