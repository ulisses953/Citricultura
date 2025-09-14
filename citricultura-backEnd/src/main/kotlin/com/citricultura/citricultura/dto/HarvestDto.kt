package com.citricultura.citricultura.dto

import java.time.LocalDate

// DTO simplificado para Harvest
// Você pode adicionar mais campos conforme necessário

data class HarvestDto(
    val date: LocalDate,
    val box: Int,
    val terrainId: Long,
    val fruitId: Long
)

