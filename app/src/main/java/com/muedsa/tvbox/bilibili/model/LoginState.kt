package com.muedsa.tvbox.bilibili.model

sealed interface LoginState {

    object NotLogin : LoginState

    data class Logged(
        val mid: Long,
        val uname: String,
        val face: String,
    ) : LoginState
}