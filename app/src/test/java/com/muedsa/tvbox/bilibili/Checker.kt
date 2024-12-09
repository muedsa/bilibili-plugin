package com.muedsa.tvbox.bilibili

import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCardRow
import com.muedsa.tvbox.api.data.MediaCardType

fun checkMediaCardRows(rows: List<MediaCardRow>) {
    rows.forEach { checkMediaCardRow(it) }
}

fun checkMediaCardRow(row: MediaCardRow) {
    check(row.title.isNotEmpty())  { "${row.title} -> title" }
    check(row.list.isNotEmpty())  { "${row.title} -> list" }
    check(row.cardWidth > 0)  { "${row.title} -> cardWidth" }
    check(row.cardHeight > 0)  { "${row.title} -> cardHeight" }
    row.list.forEach {
        checkMediaCard(card = it, cardType = row.cardType) { "${row.title} -> $it" }
    }
}

fun checkMediaCard(card: MediaCard, cardType: MediaCardType, lazyMessage: () -> Any = { "" }) {
    check(card.id.isNotEmpty()){ "${lazyMessage()} -> id" }
    check(card.title.isNotEmpty()){ "${lazyMessage()} -> title" }
    check(card.detailUrl.isNotEmpty()){ "${lazyMessage()} -> detailUrl" }
    if (cardType != MediaCardType.NOT_IMAGE) {
        check(card.coverImageUrl.isNotEmpty()) { "${lazyMessage()} -> coverImageUrl" }
    }  else {
        check(card.backgroundColor >= 0) { "${lazyMessage()} -> backgroundColor" }
    }
}