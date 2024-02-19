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

) : AuditEntity() {

    init {
        // TODO: 정규화 등 validation
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
//        require(phoneNumber.isBlank()) {"이름은 비어 있을 수 없습니다."}
    }

    companion object {

        // Object Model 패턴
        fun fixture(
            name: String = "매장 이름",
            phoneNumber: String = "01000000000",
        ): Store {
            return Store(
                name = name,
                phoneNumber = phoneNumber,
            )
        }
    }
}