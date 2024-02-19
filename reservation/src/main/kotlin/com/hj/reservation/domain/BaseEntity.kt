package com.hj.reservation.domain

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.Objects

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseEntity) return false

        return this.id == other.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}