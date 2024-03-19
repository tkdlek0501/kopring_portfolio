package com.hj.reservation.controller.user

import com.hj.reservation.dto.user.request.UserCreateRequest
import com.hj.reservation.dto.user.request.UserLoginRequest
import com.hj.reservation.dto.user.response.UserCreateResponse
import com.hj.reservation.dto.user.response.UserLoginResponse
import com.hj.reservation.service.user.UserService
import com.hj.reservation.util.fail
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/register")
    fun register(@RequestBody userCreateRequest: UserCreateRequest): ResponseEntity<UserCreateResponse> {

        if (userService.existsUser(userCreateRequest.email)) {
            fail()
        }
        userCreateRequest.password = passwordEncoder.encode(userCreateRequest.password)

        return ResponseEntity.ok(userService.createUser(userCreateRequest))
    }

    @GetMapping("/login")
    fun login(@RequestBody userLoginRequest: UserLoginRequest): ResponseEntity<UserLoginResponse> {

        return ResponseEntity.ok(userService.login(userLoginRequest))
    }
}