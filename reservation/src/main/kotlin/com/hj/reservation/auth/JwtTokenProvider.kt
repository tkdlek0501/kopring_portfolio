package com.hj.reservation.auth

import com.hj.reservation.domain.user.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider(
    private val userDetailsService: UserDetailsService,
) {

    private var secretKey = "thisistestusersecretkeyprojectnameismologaaaaaaaaaaaaaaaa"

    // 토큰 유효시간 30분
    private val tokenValidTime = 30 * 60 * 1000L

    // 객체 초기화, secretKey를 Base64로 인코딩
    @PostConstruct
    protected fun init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())
//        val keyBytes: byte[] = Decoders.BASE64.decode(secretKey.toByteArray());
//        Keys.hmacShaKeyFor(keyBytes);
    }

    // JWY 토큰 생성
    fun createToken(authentication: Authentication): String {

        val user: User = authentication.principal as User

        val now = Date()
        return Jwts.builder()
            .setHeaderParam("type", "JWT")
            .setClaims(makeClaimContents(user))
            .setIssuedAt(now)
            .setExpiration(Date(now.time + tokenValidTime))
            .signWith(SignatureAlgorithm.HS256, secretKey)
//            .signWith(key, SignatureAlgorithm.HS256) TODO: Key로 작업하기
            .compact()
    }

    fun makeClaimContents(user: User): Map<String, Any> {

        val claims: Claims = Jwts.claims()
        claims["id"] = user.id
        claims["email"] = user.email
        claims["name"] = user.name

        return claims
    }

    // JWT 토큰에서 인증 정보 조회
    fun getAuthentication(token: String): Authentication {
        val userDetails = userDetailsService.loadUserByUsername(getUserId(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    // 토큰에서 회원 정보 추출
    fun getUserId(token: String): String {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body.subject
        return Jwts.parserBuilder().setSigningKey(secretKey).build()
            .parseClaimsJws(token).body["id"].toString()
        // TODO: 확인 필요
    }

    // Request의 Header에서 token 값을 가져옵니다. "X-AUTH-TOKEN" : "TOKEN값'
    fun resolveToken(request: HttpServletRequest): String? {
        return request.getHeader("Authorization")
    }

    // 토큰의 유효성 + 만료일자 확인
    fun validateToken(jwtToken: String): Boolean {
        return try {
            val claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken)
            !claims.body.expiration.before(Date())
        } catch (e: Exception) {
            false
        }
    }
}