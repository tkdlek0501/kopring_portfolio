package com.hj.reservation.repository.store

import com.hj.reservation.domain.store.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store, Long> {

}