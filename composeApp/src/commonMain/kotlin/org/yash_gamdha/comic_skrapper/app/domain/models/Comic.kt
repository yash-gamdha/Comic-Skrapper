package org.yash_gamdha.comic_skrapper.app.domain.models

data class Comic(
    val title: String,
    val description: String,
    val imageUrl: String,
    val year: String,
    val size: String,
    val category: String,
    val detailsPageLink: String,
    val language: String? = null,
    val downloadLink: String? = null
)