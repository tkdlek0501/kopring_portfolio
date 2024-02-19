package com.hj.reservation.domain.schedule.holiday

import com.hj.reservation.domain.AuditEntity
import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
class OtherHoliday(
    val name: String,

    val startDate: LocalDateTime,

    val endDate: LocalDateTime,
) : AuditEntity() {
}