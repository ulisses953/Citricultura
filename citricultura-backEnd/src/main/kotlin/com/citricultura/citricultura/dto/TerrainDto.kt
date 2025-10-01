package com.citricultura.citricultura.dto

data class TerrainDtoRequest (
    val name: String,
    val size: Double,
    val location: String,
    val leaseValue: Double
)
data class TerrainDtoResponse (
    val id: Long?,
    val name: String,
    val size: Double,
    val location: String,
    val leaseValue: Double
)