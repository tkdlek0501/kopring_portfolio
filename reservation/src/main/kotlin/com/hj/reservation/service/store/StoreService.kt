package com.hj.reservation.service.store

import com.hj.reservation.domain.store.Store
import com.hj.reservation.dto.store.request.StoreCreateRequest
import com.hj.reservation.repository.store.StoreRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class StoreService(
    private val storeRepository: StoreRepository
) {

    @Transactional
    fun saveStore(request: StoreCreateRequest) {
        val newStore = StoreCreateRequest.toEntity(request)
        storeRepository.save(newStore)
    }
}