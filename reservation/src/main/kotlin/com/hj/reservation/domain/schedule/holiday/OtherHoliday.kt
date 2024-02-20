package com.hj.reservation.domain.schedule.holiday

import com.hj.reservation.domain.AuditEntity
import com.hj.reservation.domain.schedule.Schedule
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class OtherHoliday(
    val name: String,

    val startDate: LocalDateTime,

    val endDate: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    val schedule: Schedule
) : AuditEntity() {
}