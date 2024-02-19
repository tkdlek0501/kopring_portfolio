package com.hj.reservation.service.store

import com.hj.reservation.dto.store.request.StoreCreateRequest
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
        println("초기화")
        storeRepository.deleteAll()
    }
    // TODO: 이거 대신 transactional rollBack 사용?

    @Test
    @DisplayName(value = "매장 등록이 정상 동작 합니다.")
    fun saveStoreTest() {
        // given
        val request = StoreCreateRequest(name = "김현준 매장", phoneNumber = "01000000000")

        // when
        storeService.saveStore(request)

        // then
        val results = storeRepository.findAll()
        val id = results[0].id
        val name = results[0].name
        println("id : $id")
        println("name : $name")
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("김현준 매장")
        assertThat(results[0].phoneNumber).isEqualTo("01000000000")
    }
}