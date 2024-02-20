package com.hj.reservation.domain.store

import com.hj.reservation.domain.AuditEntity
import com.hj.reservation.domain.reservation.Reservation
import com.hj.reservation.domain.schedule.Schedule
import com.hj.reservation.domain.schedule.timetable.DateTable
import com.hj.reservation.domain.schedule.timetable.TimeTable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.hibernate.annotations.BatchSize

@Entity
class Store(
    val name: String,

    val phoneNumber: String,

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "store")
    val schedules: MutableList<Schedule> = mutableListOf(),

    @OneToMany(mappedBy = "store")
    val dateTables: MutableList<DateTable> = mutableListOf(),

    @OneToMany(mappedBy = "store")
    val reservations: MutableList<Reservation> = mutableListOf(),

    @OneToMany(mappedBy = "store")
    val timeTables: MutableList<TimeTable> = mutableListOf(),
) : AuditEntity() {

    init {
        // TODO: 정규화 등 validation
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
//        require(phoneNumber.isBlank()) {"이름은 비어 있을 수 없습니다."}
    }

    companion object {

        // Object Model 패턴
        fun fixture(
            name: String = "매장 이름",
            phoneNumber: String = "01000000000",
        ): Store {
            return Store(
                name = name,
                phoneNumber = phoneNumber,
            )
        }
    }
}