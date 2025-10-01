package com.citricultura.citricultura.dto

import java.time.LocalDate


data class HarvestDtoRequest(
    val date: LocalDate,
    val box: Int,
    val terrainId: Long,
    val fruitId: Long
)
data class HarvestDtoResponse(
    val id: Long?,
    val date: LocalDate,
    val box: Int,
    val terrainName: String,
    val fruitName: String
)


