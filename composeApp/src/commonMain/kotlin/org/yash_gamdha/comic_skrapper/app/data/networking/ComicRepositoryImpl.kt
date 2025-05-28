package org.yash_gamdha.comic_skrapper.app.data.networking

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.network.parseGetRequest
import org.yash_gamdha.comic_skrapper.app.domain.ComicRepository
import org.yash_gamdha.comic_skrapper.app.domain.models.Comic

class ComicRepositoryImpl: ComicRepository {
    override suspend fun getComics(category: String): List<Comic> {
        Ksoup.parseGetRequest(
            url = "$baseUrl/$category"
        ).let { document ->
            val comics = document.select(cssQuery = ".post-list .post-list-posts article").map { comicHtml ->
                Comic(
                    title = TODO(),
                    description = TODO(),
                    imageUrl = TODO(),
                    year = TODO(),
                    size = TODO(),
                    category = TODO(),
                    detailsPageLink = TODO()
                )
            }
            
            return comics
        }
    }

    override suspend fun getNecessaryDetails(detailsPageLink: String): Triple<String, String, String> {
        Ksoup.parseGetRequest(url = detailsPageLink).let { document ->
            val details = document.select(cssQuery = ".page-container .page-contents .post-body .post-contents p")
            val description = details[0].text()
            val language = details[1].text()
            val downloadLink = document.select(cssQuery = ".page-container .page-contents .aio-button-center .aio-pulse > a").attr("href")

            return Triple(description, language, downloadLink)
        }
    }

    override suspend fun getSearchResults(query: String): List<Comic> {
        Ksoup.parseGetRequest(url = "$baseUrl/?s=$query").let { document ->
            val comics = document.select(cssQuery = ".post-list .post-list-posts article").map { comicHtml ->
                Comic(
                    title = TODO(),
                    description = TODO(),
                    imageUrl = TODO(),
                    year = TODO(),
                    size = TODO(),
                    category = TODO(),
                    detailsPageLink = TODO()
                )
            }

            return comics
        }
    }
}