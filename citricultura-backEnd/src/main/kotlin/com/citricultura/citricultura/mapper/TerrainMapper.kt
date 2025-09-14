package com.citricultura.citricultura.mapper

import com.citricultura.citricultura.dto.TerrainDto
import com.citricultura.citricultura.entity.Terrain
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TerrainMapper {

    fun toDto(terrain: Terrain): TerrainDto

    fun toEntity(terrainDto: TerrainDto): Terrain
}