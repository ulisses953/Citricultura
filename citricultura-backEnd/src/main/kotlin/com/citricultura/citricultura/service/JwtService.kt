package com.citricultura.citricultura.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.Date

@Service
class JwtService(
    @Value("\${spring.security.jwt.secret}") val secret: String,
    @Value("\${spring.security.jwt.expiration-hours}") val expiration: Long
) {

    val algorithm: Algorithm = Algorithm.HMAC256(secret)

    fun generateToken(username: String): String {
        val token = JWT
            .create()
            .withSubject(username)
            .withExpiresAt(genExpirationDate())
            .sign(algorithm)

        return token;
    }

    fun validateToken(token: String): String {
        val username = JWT
            .require(algorithm)
            .build()
            .verify(token)
            .subject

        return username
    }

    fun genExpirationDate(): Date {
        val now = Date()

        val expirationMillis = expiration * 60 * 60 * 1000

        return Date(now.time + expirationMillis)
    }
}