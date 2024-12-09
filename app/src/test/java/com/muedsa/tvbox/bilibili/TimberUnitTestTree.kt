package com.muedsa.tvbox.bilibili

import timber.log.Timber

class TimberUnitTestTree : Timber.Tree() {
    override fun log(
        priority: Int,
        tag: String?,
        message: String,
        t: Throwable?
    ) {
        println("[$priority][${tag ?: "*"}] $message")
        t?.let { println(it)}
    }

}