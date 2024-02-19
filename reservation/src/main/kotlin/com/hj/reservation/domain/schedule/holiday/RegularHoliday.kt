package com.hj.reservation.domain.schedule.holiday

import com.hj.reservation.domain.AuditEntity
import jakarta.persistence.Entity

@Entity
class RegularHoliday(
    val name: String,
) : AuditEntity() {
}