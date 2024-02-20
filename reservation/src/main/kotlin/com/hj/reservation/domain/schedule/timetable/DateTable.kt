package com.hj.reservation.domain.schedule.timetable

import com.hj.reservation.domain.AuditEntity
import com.hj.reservation.domain.schedule.Schedule
import com.hj.reservation.domain.schedule.operation.DateOperation
import com.hj.reservation.domain.store.Store
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class DateTable(
    val name: String,

    val dayMaxPerson: Int,

    val available: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    val schedule: Schedule,

    @OneToMany(mappedBy = "dateTable")
    val timeTables: MutableList<TimeTable> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    val store: Store,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "date_operation_id")
    val dateOperation: DateOperation,
) : AuditEntity() {
}