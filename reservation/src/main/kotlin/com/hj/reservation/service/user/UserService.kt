package com.hj.reservation.service.user

import com.hj.reservation.auth.JwtTokenProvider
import com.hj.reservation.domain.user.User
import com.hj.reservation.repository.user.UserRepository
import com.hj.reservation.util.fail
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider
    ) {
    fun findUser(email: String): User {
        return userRepository.findByEmail(email) ?: fail()
    }

    fun existsUser(email: String): Boolean {
        return userRepository.existsByEmail(email) ?: fail() // .orElseThrow{BaseException(BaseResponseCode.DUPLICATE_EMAIL)}
    }

    fun createUser(createUserRequest: CreateUserRequest): CreateUserResponse {
        val user = User(createUserRequest.name, createUserRequest.email, createUserRequest.password)
        userRepository.save(user)

        return CreateUserResponse(user.id, user.email)
    }

    fun login(userLoginRequest: UserLoginRequest): UserLoginResponse {
        val token: String = jwtTokenProvider.createToken(userLoginRequest.email)

        return UserLoginResponse(HttpStatus.OK, token)
    }
}