package com.citricultura.citricultura.service

import com.citricultura.citricultura.dto.AuthDtoRequest
import com.citricultura.citricultura.dto.AuthDtoResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthService(private val authenticationManager: AuthenticationManager,
                  private val jwtService: JwtService) {

    fun login(authDto: AuthDtoRequest) : AuthDtoResponse {
        val userNamePassword = UsernamePasswordAuthenticationToken(authDto.email, authDto.password)

        val auth = authenticationManager.authenticate(userNamePassword)

        val token = jwtService.generateToken(auth.name)

        return AuthDtoResponse(token, "")
    }

}