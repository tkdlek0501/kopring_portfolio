package com.hj.reservation.domain.reservation

import com.hj.reservation.domain.AuditEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class ReservationHistory(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    val reservation: Reservation,
) : AuditEntity() {
}