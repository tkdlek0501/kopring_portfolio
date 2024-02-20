package com.hj.reservation.domain.schedule.timetable

import com.hj.reservation.domain.AuditEntity
import com.hj.reservation.domain.reservation.Reservation
import com.hj.reservation.domain.schedule.Schedule
import com.hj.reservation.domain.schedule.operation.DateOperation
import com.hj.reservation.domain.schedule.operation.TimeOperation
import com.hj.reservation.domain.store.Store
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.util.Date

@Entity
class TimeTable(
    val timeMaxPerson: Int,

    val available: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    val schedule: Schedule,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    val store: Store,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "date_table_id")
    val dateTable: DateTable,

    @OneToMany(mappedBy = "timeTable")
    val reservations: MutableList<Reservation> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "date_operation_id")
    val dateOperation: DateOperation,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_operation_id")
    val timeOperation: TimeOperation,
    ) : AuditEntity() {
}