package com.hj.reservation.dto.user.response

import com.hj.reservation.domain.user.User

data class UserCreateResponse(
    val id: Long,
    val name: String,
    val email: String,
) {

    companion object {

        fun of(
            entity: User
        ): UserCreateResponse {
            return UserCreateResponse(
                id = entity.id!!,
                name = entity.name,
                email =  entity.email,
            )
        }
    }
}