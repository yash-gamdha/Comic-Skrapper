package org.yash_gamdha.comic_skrapper

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform