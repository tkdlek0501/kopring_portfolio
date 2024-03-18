package com.hj.reservation.controller.user

import com.hj.reservation.service.user.UserService
import com.hj.reservation.util.fail
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/register")
    fun register(@RequestBody createUserRequest: CreateUserRequest): ResponseEntity<CreateUserResponse> {

        if (userService.existsUser(createUserRequest.email)) {
            fail()
        }
        createUserRequest.password = passwordEncoder.encode(createUserRequest.password)

        return ResponseEntity.ok(userService.createUser(createUserRequest))
    }
}