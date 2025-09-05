package com.citricultura.citricultura.dto

data class AuthDto(
    val email: String,
    val password : String
)

data class AuthResponseDto(
    val token: String,
    val refreshToken : String
)