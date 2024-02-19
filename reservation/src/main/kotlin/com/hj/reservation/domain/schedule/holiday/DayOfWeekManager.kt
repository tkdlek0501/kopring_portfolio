package com.hj.reservation.domain.schedule.holiday

import com.hj.reservation.domain.AuditEntity
import jakarta.persistence.*
import java.time.DayOfWeek

@Entity
class DayOfWeekManager(

    @Enumerated(EnumType.STRING)
    val dayOfWeek: DayOfWeek,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regular_holiday_id")
    val regularHoliday: RegularHoliday,

    ) : AuditEntity() {
}