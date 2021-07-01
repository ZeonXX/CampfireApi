package com.dzen.campfire.api.models.publications

import com.dzen.campfire.api.models.publications.post.Page

interface PagesContainer {

    fun getPagesArray(): Array<Page>

    fun getSourceType(): Long

    fun getSourceId(): Long

    fun getSourceIdSub(): Long
}