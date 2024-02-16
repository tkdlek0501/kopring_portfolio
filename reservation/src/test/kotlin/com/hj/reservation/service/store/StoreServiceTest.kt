package com.hj.reservation.service.store

import com.hj.reservation.repository.store.StoreRepository
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StoreServiceTest @Autowired constructor(

    private val storeService: StoreService,

    private val storeRepository: StoreRepository,
){

    @AfterEach
    fun clean() {
        storeRepository.deleteAll()
    }

    @Test
    @DisplayName(value = "매장 등록이 정상 동작 합니다.")
    fun saveStoreTest() {
        // given
        // TODO: request dto

        // when
//        storeService.saveStore()

        // then
//        val results = storeRepository.findAll()
//        assertThat(results).hasSize(1)
//        assertThat(results[0].name).isEqualTo("")
//        assertThat(results[0].phoneNumber).isEqualTo("")
    }
}