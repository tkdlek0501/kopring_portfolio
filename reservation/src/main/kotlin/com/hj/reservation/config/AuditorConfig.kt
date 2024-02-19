package com.hj.reservation.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

@Configuration
class AuditorConfig {

    @Bean
    fun auditorProvider(): AuditorAware<String> {
        val authentication = SecurityContextHolder.getContext().authentication

        return if (authentication == null || !authentication.isAuthenticated) {
            AuditorAware { Optional.empty() }
        } else {
            AuditorAware { Optional.ofNullable(authentication.name) }
        }
    }
}