package com.hj.reservation.controller.store

import com.hj.reservation.dto.store.request.StoreCreateRequest
import com.hj.reservation.service.store.StoreService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/store")
class StoreController(
    private val storeService: StoreService
) {

    @PostMapping("")
    fun saveStore(@RequestBody request: StoreCreateRequest) {
        storeService.saveStore(request)
    }

}