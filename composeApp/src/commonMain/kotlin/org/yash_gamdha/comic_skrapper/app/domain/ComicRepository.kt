package org.yash_gamdha.comic_skrapper.app.domain

import org.yash_gamdha.comic_skrapper.app.domain.models.Comic

interface ComicRepository {
    val baseUrl: String
        get() = "https://getcomics.org"

    // for home page
    suspend fun getComics(category: String = ""): List<Comic>

    // for detail page
    suspend fun getNecessaryDetails(detailsPageLink: String): Triple<String, String, String> // description, language, download link

    // for search results
    suspend fun getSearchResults(query: String): List<Comic>
}