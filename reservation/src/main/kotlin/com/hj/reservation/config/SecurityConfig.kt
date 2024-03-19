package com.hj.reservation.config

import com.hj.reservation.auth.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .csrf { csrf ->
                csrf.disable() // CSRF 보안 비활성화
            }
            .cors { cors ->
                cors.disable()
            }
//            .sessionManagement { sessionManagement ->
//                sessionManagement
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 생성 정책 설정
//            }
            .authorizeExchange { authorize ->
                authorize
                    .pathMatchers("/login/**").permitAll()
//                    .pathMatchers("/admin/**").hasRole("ADMIN")
                    .anyExchange().authenticated()
            }
//            .httpBasic { httpBasic ->
//                httpBasic.realmName("My Realm")
//            }
            .build()
    }
}