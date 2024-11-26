package com.muedsa.tvbox.demoplugin.helper

fun <T> splitListBySize(inputList: List<T>, size: Int): List<List<T>> {
    val result = mutableListOf<List<T>>()
    var index = 0
    while (index < inputList.size) {
        result.add(inputList.subList(index, (index + size).coerceAtMost(inputList.size)))
        index += size
    }
    return result
}