package com.hj.reservation.dto.store.request

import com.hj.reservation.domain.store.Store

data class StoreCreateRequest(
    val name: String,
    val phoneNumber: String,
) {
    companion object {

        fun toEntity(
            request: StoreCreateRequest
        ): Store {
            return Store(
                name = request.name,
                phoneNumber = request.phoneNumber,
            )
        }
    }
}