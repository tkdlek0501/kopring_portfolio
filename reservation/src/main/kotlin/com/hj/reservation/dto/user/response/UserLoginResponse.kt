package com.hj.reservation.dto.user.response

data class UserLoginResponse(
    val token: String,
) {

    companion object {

        fun of(token: String): UserLoginResponse {
            return UserLoginResponse(
                token = token,
            )
        }
    }
}