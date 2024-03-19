package com.hj.reservation.service.user

import com.hj.reservation.auth.JwtTokenProvider
import com.hj.reservation.domain.user.User
import com.hj.reservation.dto.user.request.UserCreateRequest
import com.hj.reservation.dto.user.request.UserLoginRequest
import com.hj.reservation.dto.user.response.UserCreateResponse
import com.hj.reservation.dto.user.response.UserLoginResponse
import com.hj.reservation.repository.user.UserRepository
import com.hj.reservation.util.fail
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val passwordEncoder: PasswordEncoder
    ) {
    fun findUser(email: String): User {
        return userRepository.findByEmail(email) ?: fail()
    }

    fun existsUser(email: String): Boolean {
        return userRepository.existsByEmail(email) ?: fail() // .orElseThrow{BaseException(BaseResponseCode.DUPLICATE_EMAIL)}
    }

    fun createUser(createUserRequest: UserCreateRequest): UserCreateResponse {
        val user = User(createUserRequest.name, createUserRequest.email, createUserRequest.password)
        userRepository.save(user)

        return UserCreateResponse.of(user)
    }

    fun login(userLoginRequest: UserLoginRequest): UserLoginResponse {

        // 존재하는 유저인지 검증 -> loadUserByUsername 에서 대신
//        if (!existsUser(userLoginRequest.email)) {
//            throw BaseException(BaseResponseCode.USER_NOT_FOUND)
//        }

        val authenticationToken =
            UsernamePasswordAuthenticationToken(userLoginRequest.email, userLoginRequest.password)

        // authenticate 메소드가 실행이 될 때 UserDetailsService의 loadUserByUsername 메소드가 실행
        val authentication: Authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

        val user: User = findUser(userLoginRequest.email)

        // 비밀번호 일치 검증
        if (!passwordEncoder.matches(userLoginRequest.password, user.password)) {
//            throw BaseException(BaseResponseCode.INVALID_PASSWORD)
            // TODO: exception 작업
        }

        // 해당 객체를 SecurityContextHolder에 저장하고
        SecurityContextHolder.getContext().authentication = authentication;

        // authentication 객체를 createToken 메소드를 통해서 JWT 을 생성
        val token: String = jwtTokenProvider.createToken(authentication)

        // response header에 jwt 넣어줌
        val httpHeaders = HttpHeaders()
//        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + token);
        // TODO: header에 JWT 넣어주기

        return UserLoginResponse.of(token)
    }
}