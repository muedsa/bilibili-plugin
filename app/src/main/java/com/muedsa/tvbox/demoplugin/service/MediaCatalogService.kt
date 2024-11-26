package com.muedsa.tvbox.demoplugin.service

import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCatalogConfig
import com.muedsa.tvbox.api.data.MediaCatalogOption
import com.muedsa.tvbox.api.data.MediaCatalogOptionItem
import com.muedsa.tvbox.api.data.PagingResult
import com.muedsa.tvbox.api.service.IMediaCatalogService
import com.muedsa.tvbox.demoplugin.helper.splitListBySize

class MediaCatalogService(
    private val danDanPlayApiService: DanDanPlayApiService
) : IMediaCatalogService {

    override suspend fun getConfig(): MediaCatalogConfig {
        val resp = danDanPlayApiService.getSeasonYearMonth()
        if (resp.errorCode != 0) {
            throw RuntimeException(resp.errorMessage)
        }
        return MediaCatalogConfig(
            initKey = "1",
            pageSize = 20,
            cardWidth = 210 / 2,
            cardHeight = 302 / 2,
            catalogOptions = buildList {
                if (resp.seasons.isNotEmpty()) {
                    add(
                        MediaCatalogOption(
                            name = "年份",
                            value = "year",
                            items = resp.seasons.map{ it.year }.distinct().mapIndexed { index, year ->
                                MediaCatalogOptionItem(
                                    name = year.toString(),
                                    value = year.toString(),
                                    defaultChecked = index == 0
                                )
                            },
                            required = true
                        )
                    )
                    val firstMonth = resp.seasons.first().month
                    add(
                        MediaCatalogOption(
                            name = "月份",
                            value = "month",
                            items = buildList {
                                for (month in 1 .. 12) {
                                    add(
                                        MediaCatalogOptionItem(
                                            name = month.toString(),
                                            value = month.toString(),
                                            defaultChecked = month == firstMonth
                                        )
                                    )
                                }
                            },
                            required = true
                        )
                    )

                    add(
                        MediaCatalogOption(
                            name = "Other",
                            value = "other",
                            items = buildList {
                                for (i in 0 .. 8) {
                                    add(
                                        MediaCatalogOptionItem(
                                            name = "other$i",
                                            value = i.toString(),
                                        )
                                    )
                                }
                            },
                            multiple = true
                        )
                    )
                }
            }
        )
    }

    override suspend fun catalog(
        options: List<MediaCatalogOption>,
        loadKey: String,
        loadSize: Int
    ): PagingResult<MediaCard> {
        val pageIndex = loadKey.toInt() - 1
        val year = options.find { option -> option.value == "year" }?.items[0]?.value ?: throw RuntimeException("年份为必选项")
        val month = options.find { option -> option.value == "month" }?.items[0]?.value ?: throw RuntimeException("月份为必选项")
        val resp = danDanPlayApiService.getSeasonAnime(year, month)
        if (resp.errorCode != 0) {
            throw RuntimeException(resp.errorMessage)
        }
        val pages = splitListBySize(resp.bangumiList, loadSize)
        println("${pages.size}")
        pages.forEach { t -> println("${t.size}") }
        return PagingResult<MediaCard>(
            list = if (pageIndex >= 0 && pageIndex < pages.size) {
                pages[pageIndex].map {
                    MediaCard(
                        id = it.animeId.toString(),
                        title = it.animeTitle,
                        detailUrl = it.animeId.toString(),
                        coverImageUrl = it.imageUrl
                    )
                }
            } else emptyList(),
            nextKey = if (pageIndex + 1 < pages.size) "${pageIndex + 2}" else null,
            prevKey = if (pageIndex - 1 >= 0) "$pageIndex" else null
        )
    }
}