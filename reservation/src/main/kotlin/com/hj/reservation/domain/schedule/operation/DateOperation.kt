package com.hj.reservation.domain.schedule.operation

import com.hj.reservation.domain.AuditEntity
import jakarta.persistence.Entity

@Entity
class DateOperation(
    val name: String,
) : AuditEntity() {
}