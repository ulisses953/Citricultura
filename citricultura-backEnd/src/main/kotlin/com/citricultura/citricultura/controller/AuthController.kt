package com.citricultura.citricultura.controller

import com.citricultura.citricultura.dto.AuthDto
import com.citricultura.citricultura.dto.AuthResponseDto
import com.citricultura.citricultura.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping()
    fun login(@RequestBody authDto: AuthDto): ResponseEntity<AuthResponseDto>{
        val authResponse = authService.login(authDto)
        return ResponseEntity.ok(authResponse)
    }


}