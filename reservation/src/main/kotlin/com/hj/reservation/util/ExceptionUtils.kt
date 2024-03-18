package com.hj.reservation.util

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull

fun fail(): Nothing {
    throw IllegalArgumentException()
}

fun <T, ID> CrudRepository<T, ID>.findByIdOrThrow(id: ID): T {
    return this.findByIdOrNull(id) ?: fail()
}
// CrudRepository 의 확장 함수를 커스텀
// null 로 찾아왔을 때 exception 을 발생 시키는 메서드

//fun BookRepository.findByNameOrThrow(bookName: String): Book {
//    return this.findByName(bookName) ?: fail()
//}
//
//fun UserRepository.findByNameOrThrow(userName: String): User {
//    return this.findByName(userName) ?: fail()
//}