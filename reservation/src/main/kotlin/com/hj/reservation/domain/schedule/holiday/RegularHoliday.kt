package com.hj.reservation.domain.schedule.holiday

import com.hj.reservation.domain.AuditEntity
import com.hj.reservation.domain.schedule.Schedule
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.time.DayOfWeek
import java.time.LocalDateTime

@Entity
class RegularHoliday(
    val name: String,

    val startDate: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    val schedule: Schedule,

    @BatchSize(size = 200)
    @OneToMany(mappedBy = "regularHoliday")
    val dayOfWeekManagers: MutableList<DayOfWeekManager> = mutableListOf(),

    @Enumerated(EnumType.STRING)
    val periodUnit: PeriodUnit,

) : AuditEntity() {
}