package com.hj.reservation.domain.schedule.operation

import com.hj.reservation.domain.AuditEntity
import com.hj.reservation.domain.schedule.Schedule
import com.hj.reservation.domain.schedule.timetable.DateTable
import com.hj.reservation.domain.schedule.timetable.TimeTable
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDate

@Entity
class DateOperation(
    val name: String,

    val timeUnit: TimeUnit,

    val startDate: LocalDate,

    val endDate: LocalDate,

    val dayMaxPerson: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    val schedule: Schedule,

    @OneToMany(mappedBy = "dateOperation")
    val timeOperations: MutableList<TimeOperation> = mutableListOf(),

    @OneToMany(mappedBy = "dateOperation")
    val dateTables: MutableList<DateTable> = mutableListOf(),

    @OneToMany(mappedBy = "timeOperation")
    val timeTables: MutableList<TimeTable> = mutableListOf(),
    ) : AuditEntity() {
}