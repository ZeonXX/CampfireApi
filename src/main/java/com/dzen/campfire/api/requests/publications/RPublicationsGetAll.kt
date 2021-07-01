package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.Publication
import com.dzen.campfire.api.models.publications.tags.PublicationTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPublicationsGetAll : Request<RPublicationsGetAll.Response>() {

    companion object {
        val ORDER_NEW = 1
        val ORDER_OLD = 2
        val ORDER_KARMA = 3
        val ORDER_DOWNLOADS = 4
    }


    var accountId = 0L
    var offset = 0L
    var fandomId = 0L
    var fandomsIds = emptyArray<Long>()
    var drafts = false
    var publicationsTypes: Array<Long>? = null
    var parentPublicationId = 0L
    var order = ORDER_NEW
    var count = 20
    var languageId = 0L
    var tags: Array<Long>? = null
    var includeZeroLanguages = false
    var includeModerationsBlocks = true
    var includeModerationsOther = true
    var includeMultilingual = false
    var onlyWithFandom = false
    var appKey:String? = null
    var appSubKey:String? = null
    var important = API.PUBLICATION_IMPORTANT_NONE

    init {
        cashAvailable = false
        tokenRequired = false
    }

    fun setParentPublicationId(parentPublicationId: Long): RPublicationsGetAll {
        this.parentPublicationId = parentPublicationId
        return this
    }

    fun setAccountId(accountId: Long): RPublicationsGetAll {
        this.accountId = accountId
        return this
    }

    fun setOffset(offset: Int): RPublicationsGetAll {
        return setOffset(offset.toLong())
    }

    fun setOffset(offset: Long): RPublicationsGetAll {
        this.offset = offset
        return this
    }

    fun setPublicationTypes(vararg publicationTypes: Long): RPublicationsGetAll {
        return setPublicationTypes(publicationTypes.toTypedArray())
    }

    fun setPublicationTypes(publicationTypes: Array<Long>): RPublicationsGetAll {
        this.publicationsTypes = publicationTypes
        return this
    }

    fun setOrder(order: Int): RPublicationsGetAll {
        this.order = order
        return this
    }

    fun setIncludeZeroLanguages(includeZeroLanguages: Boolean): RPublicationsGetAll {
        this.includeZeroLanguages = includeZeroLanguages
        return this
    }

    fun setIncludeModerationsBlocks(includeModerationsBlocks: Boolean): RPublicationsGetAll {
        this.includeModerationsBlocks = includeModerationsBlocks
        return this
    }

    fun setImportant(important: Long): RPublicationsGetAll {
        this.important = important
        return this
    }

    fun setIncludeModerationsOther(includeModerationsOther: Boolean): RPublicationsGetAll {
        this.includeModerationsOther = includeModerationsOther
        return this
    }

    fun setIncludeMultilingual(includeMultilingual: Boolean): RPublicationsGetAll {
        this.includeMultilingual = includeMultilingual
        return this
    }

    fun setOnlyWithFandom(onlyWithFandom: Boolean): RPublicationsGetAll {
        this.onlyWithFandom = onlyWithFandom
        return this
    }

    fun setDrafts(drafts: Boolean): RPublicationsGetAll {
        this.drafts = drafts
        return this
    }

    fun setLanguageId(languageId: Long): RPublicationsGetAll {
        this.languageId = languageId
        return this
    }

    fun setCount(count: Int): RPublicationsGetAll {
        this.count = count
        return this
    }

    fun setFandomId(fandomId: Long): RPublicationsGetAll {
        this.fandomId = fandomId
        return this
    }
    fun setFandomsIds(fandomsIds: Array<Long>): RPublicationsGetAll {
        this.fandomsIds = fandomsIds
        return this
    }
    fun setAppKey(appKey: String): RPublicationsGetAll {
        this.appKey = appKey
        return this
    }

    fun setAppSubKey(appSubKey: String): RPublicationsGetAll {
        this.appSubKey = appSubKey
        return this
    }

    fun setTags(vararg tags: Long): RPublicationsGetAll {
        this.tags = tags.toTypedArray()
        return this
    }

    fun setTags(vararg tags: PublicationTag): RPublicationsGetAll {
        this.tags = Array(tags.size) {tags[it].id}
        return this
    }

    fun setTokenRequired(tokenRequired: Boolean): RPublicationsGetAll {
        this.tokenRequired = tokenRequired
        return this
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        parentPublicationId = json.m(inp, "parentUnitId", parentPublicationId)
        offset = json.m(inp, "offset", offset)
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomsIds = json.m(inp, "fandomsIds", fandomsIds)
        important = json.m(inp, "important", important)
        drafts = json.m(inp, "drafts", drafts)
        includeZeroLanguages = json.m(inp, "includeZeroLanguages", includeZeroLanguages)
        includeModerationsBlocks = json.m(inp, "includeModerationsBlocks", includeModerationsBlocks)
        includeModerationsOther = json.m(inp, "includeModerationsOther", includeModerationsOther)
        includeMultilingual = json.m(inp, "includeMultilingual", includeMultilingual)
        publicationsTypes = json.mNull(inp, "unitTypes", publicationsTypes, Array<Long>::class)?: emptyArray()
        order = json.m(inp, "order", order)
        languageId = json.m(inp, "languageId", languageId)
        onlyWithFandom = json.m(inp, "onlyWithFandom", onlyWithFandom)
        count = json.m(inp, "count", count)
        appKey = json.mNull(inp, "appKey", appKey, String::class)
        appSubKey = json.mNull(inp, "appSubKey", appSubKey, String::class)
        tags = json.mNull(inp, "tags", tags, Array<Long>::class)?: emptyArray()
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publications: Array<Publication> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publications: Array<Publication>) {
            this.publications = publications
        }

        override fun json(inp: Boolean, json: Json) {
            publications = json.m(inp, "units", publications, Array<Publication>::class)
        }

    }

}