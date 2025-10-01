package com.citricultura.citricultura.controller

import com.citricultura.citricultura.dto.AuthDtoRequest
import com.citricultura.citricultura.dto.AuthDtoResponse
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
    fun login(@RequestBody authDto: AuthDtoRequest): ResponseEntity<AuthDtoResponse>{
        val authResponse = authService.login(authDto)
        return ResponseEntity.ok(authResponse)
    }


}