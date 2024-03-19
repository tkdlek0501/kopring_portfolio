package com.hj.reservation.dto.user.request

import org.jetbrains.annotations.NotNull

data class UserLoginRequest(
    @field: NotNull
    val email: String,
    @field: NotNull
    var password: String,
) {

}