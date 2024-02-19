package com.hj.reservation.dto.store.request

import com.hj.reservation.domain.store.Store
import org.jetbrains.annotations.NotNull

data class StoreCreateRequest(
    @field: NotNull
    val name: String,
    @field: NotNull
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