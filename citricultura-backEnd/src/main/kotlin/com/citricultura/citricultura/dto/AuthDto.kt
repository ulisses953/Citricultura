package com.citricultura.citricultura.dto

data class AuthDtoRequest(
    val email: String,
    val password : String
)

data class AuthDtoResponse(
    val token: String,
    val refreshToken : String
)