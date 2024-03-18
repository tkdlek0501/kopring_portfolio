package com.hj.reservation.repository.user

import com.hj.reservation.domain.store.Store
import com.hj.reservation.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String?): User?

    fun existsByEmail(email: String): Boolean?
}