package com.citricultura.citricultura.dto

data class FruitDTORequest(
    val name: String
)

data class FruitDTOResponse(
    val id: Long?,
    val name: String
)
