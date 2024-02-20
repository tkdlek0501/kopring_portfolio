package com.hj.reservation.domain.schedule

import com.hj.reservation.domain.AuditEntity
import com.hj.reservation.domain.schedule.holiday.OtherHoliday
import com.hj.reservation.domain.schedule.holiday.RegularHoliday
import com.hj.reservation.domain.schedule.operation.DateOperation
import com.hj.reservation.domain.schedule.timetable.DateTable
import com.hj.reservation.domain.schedule.timetable.TimeTable
import com.hj.reservation.domain.store.Store
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class Schedule(
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    val store: Store,

    @OneToMany(mappedBy = "schedule")
    val regularHolidays: MutableList<RegularHoliday> = mutableListOf(),

    @OneToMany(mappedBy = "schedule")
    val dateOperations: MutableList<DateOperation> = mutableListOf(),

    @OneToMany(mappedBy = "otherHoliday")
    val otherHolidays: MutableList<OtherHoliday> = mutableListOf(),

    @OneToMany(mappedBy = "dateTable")
    val dateTables: MutableList<DateTable> = mutableListOf(),

    @OneToMany(mappedBy = "timeTable")
    val timeTables: MutableList<TimeTable> = mutableListOf(),
) : AuditEntity() {
}