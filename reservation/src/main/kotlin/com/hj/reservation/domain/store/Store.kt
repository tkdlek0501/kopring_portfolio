package com.hj.reservation.domain.store

import com.hj.reservation.domain.AuditEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Store(
    val name: String,

    val phoneNumber: String,

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long? = null,
) : AuditEntity() {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
        // TODO: 정규화 등 validation
    }

    companion object {

        // Object Model 패턴
        fun fixture(
            name: String = "매장 이름",
            phoneNumber: String = "01000000000",
//            id: Long? = null,
        ): Store {
            return Store(
                name = name,
                phoneNumber = phoneNumber,
//                id = id,
            )
        }
    }
}