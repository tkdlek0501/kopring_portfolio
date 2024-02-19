package com.hj.reservation.domain.schedule

import com.hj.reservation.domain.AuditEntity
import jakarta.persistence.Entity

@Entity
class Schedule(
    val name: String,
) : AuditEntity() {
}