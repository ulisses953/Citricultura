package com.citricultura.citricultura.service

import com.citricultura.citricultura.dto.AuthDto
import com.citricultura.citricultura.dto.AuthResponseDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthService(private val authenticationManager: AuthenticationManager,
                  private val jwtService: JwtService) {

    fun login(authDto: AuthDto) : AuthResponseDto {
        val userNamePassword = UsernamePasswordAuthenticationToken(authDto.email, authDto.password)

        val auth = authenticationManager.authenticate(userNamePassword)

        val token = jwtService.generateToken(auth.name)

        return AuthResponseDto(token, "")
    }

}