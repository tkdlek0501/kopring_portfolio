package com.hj.reservation.domain.schedule.operation

import com.hj.reservation.domain.AuditEntity
import com.hj.reservation.domain.schedule.timetable.TimeTable
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalTime

@Entity
class TimeOperation(
    val name: String,

    val startTime: LocalTime,

    val endTime: LocalTime,

    val timeMaxPerson: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "date_operation_id")
    val dateOperation: DateOperation,

    @OneToMany(mappedBy = "timeOperation")
    val timeTables: MutableList<TimeTable> = mutableListOf(),
) : AuditEntity() {
}