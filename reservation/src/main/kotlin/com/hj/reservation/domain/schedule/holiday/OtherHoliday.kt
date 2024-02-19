package com.hj.reservation.domain.schedule.holiday

import com.hj.reservation.domain.AuditEntity
import jakarta.persistence.Entity

@Entity
class OtherHoliday(
    val name: String,
) : AuditEntity() {
}