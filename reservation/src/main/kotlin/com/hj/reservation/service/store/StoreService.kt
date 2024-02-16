package com.hj.reservation.service.store

import com.hj.reservation.domain.store.Store
import com.hj.reservation.repository.store.StoreRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class StoreService(
    private val storeRepository: StoreRepository
) {

    fun saveStore(request: Any) {
        val newStore = Store.fixture()
        storeRepository.save(newStore)
    }
}