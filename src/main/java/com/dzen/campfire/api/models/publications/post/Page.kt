package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonPolimorf


abstract class Page : JsonPolimorf {

    override fun json(inp: Boolean, json: Json): Json {
        if (inp) json.put(J_PAGE_TYPE, getType())
        return json
    }

    abstract fun getType(): Long

    open fun addInsertData(request: Request<*>) {

    }

    open fun restoreInsertData(request: Request<*>, offset: Int): Int {
        return 0
    }

    open fun isRemoveOnChange() = true

    abstract fun fillResourcesList(list: ArrayList<Long>)

    open fun prepareForServer(page: Page) {

    }

    open fun copyChangeData(page:Page){

    }

    companion object {

        private val J_PAGE_TYPE = "J_PAGE_TYPE"

        //
        //  Static
        //

        @JvmStatic
        fun instance(json: Json): Page {
            val type = json.get<Long>(J_PAGE_TYPE)!!
            var isNull = false

            val page: Page
            when (type) {
                API.PAGE_TYPE_TEXT -> page = PageText()
                API.PAGE_TYPE_IMAGE -> page = PageImage()
                API.PAGE_TYPE_IMAGES -> page = PageImages()
                API.PAGE_TYPE_LINK -> page = PageLink()
                API.PAGE_TYPE_QUOTE -> page = PageQuote()
                API.PAGE_TYPE_SPOILER -> page = PageSpoiler()
                API.PAGE_TYPE_POLLING -> page = PagePolling()
                API.PAGE_TYPE_VIDEO -> page = PageVideo()
                API.PAGE_TYPE_TABLE -> page = PageTable()
                API.PAGE_TYPE_DOWNLOAD -> page = PageDownload()
                API.PAGE_TYPE_CAMPFIRE_OBJECT -> page = PageCampfireObject()
                API.PAGE_TYPE_USER_ACTIVITY -> page = PageUserActivity()
                API.PAGE_TYPE_LINK_IMAGE -> page = PageLinkImage()
                API.PAGE_TYPE_CODE -> page = PageCode()
                else -> {
                    page = PageText()
                    isNull = true
                }
            }

            page.json(false, json)
            if (isNull) {
                (page as PageText).text = "[null]"
                page.size = PageText.SIZE_0
            }
            return page
        }
    }

}
