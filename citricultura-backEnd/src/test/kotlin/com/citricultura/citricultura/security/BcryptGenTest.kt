package com.citricultura.citricultura.security

import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class BcryptGenTest {
    @Test
    fun printHashes() {
        val encoder = BCryptPasswordEncoder()
        val adminHash = encoder.encode("admin123")
        val userHash = encoder.encode("user123")
        println("ADMIN_HASH=$adminHash")
        println("USER_HASH=$userHash")
    }
}
