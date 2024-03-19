package com.hj.reservation.dto.user.request

import com.hj.reservation.domain.user.User
import org.jetbrains.annotations.NotNull

data class UserCreateRequest(
    @field: NotNull
    val name: String,
    @field: NotNull
    val email: String,
    @field: NotNull
    var password: String,
) {

    companion object {

        fun toEntity(
            request: UserCreateRequest
        ): User {
            return User(
                name = request.name,
                email = request.email,
                password = request.password,
            )
        }
    }
}