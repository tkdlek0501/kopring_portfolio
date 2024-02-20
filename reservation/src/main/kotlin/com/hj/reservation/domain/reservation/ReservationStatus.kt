package com.hj.reservation.domain.reservation

enum class ReservationStatus(val value: String) {

    REQUEST_CONFIRM("예약 확정"),

    MODIFY_REQUEST("예약 변경 요청"),

    MODIFY_CONFIRM("예약 변경 확정"),

    MODIFY_REFUSE("예약 변경 거절"),

    CANCEL_CONFIRM("예약 취소 확정"),

    STORE_CANCEL("매장 예약 취소"),

    NOSHOW("고객 노쇼"),

    COMPLETE("완료")

}