package com.hj.reservation.domain.schedule.operation

import com.hj.reservation.domain.AuditEntity
import jakarta.persistence.Entity

@Entity
class TimeOperation(
    val name: String,
) : AuditEntity() {
}