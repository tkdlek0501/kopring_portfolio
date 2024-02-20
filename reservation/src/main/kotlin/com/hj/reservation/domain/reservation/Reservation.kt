package com.hj.reservation.domain.reservation

import com.hj.reservation.domain.AuditEntity
import com.hj.reservation.domain.schedule.timetable.TimeTable
import com.hj.reservation.domain.store.Store
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity
class Reservation(
    val status: ReservationStatus,

    val requestDateTime: LocalDateTime,

    val person: Int,

    val lastReason: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_table_id")
    val timeTable: TimeTable,

    @OneToMany(mappedBy = "reservation")
    val reservationHistories: MutableList<ReservationHistory> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    val store: Store,
    ) : AuditEntity() {
}