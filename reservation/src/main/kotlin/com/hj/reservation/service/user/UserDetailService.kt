package com.hj.reservation.service.user

import com.hj.reservation.repository.user.UserRepository
import com.hj.reservation.util.fail
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepository.findByEmail(username) ?: fail() // .orElseThrow{
//            BaseException(BaseResponseCode.USER_NOT_FOUND)
//        }
    }
}