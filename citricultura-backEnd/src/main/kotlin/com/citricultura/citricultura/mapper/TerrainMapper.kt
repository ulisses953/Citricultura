package com.citricultura.citricultura.mapper

import com.citricultura.citricultura.dto.TerrainDtoRequest
import com.citricultura.citricultura.dto.TerrainDtoResponse
import com.citricultura.citricultura.entity.Terrain
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface TerrainMapper {

    fun toDto(terrain: Terrain): TerrainDtoResponse

    @Mapping(target = "id", ignore = true)
    fun toEntity(request: TerrainDtoRequest): Terrain

    // Atualiza uma entidade existente com os campos do request (mantendo o id)
    @Mapping(target = "id", ignore = true)
    fun updateEntityFromRequest(request: TerrainDtoRequest, @MappingTarget terrain: Terrain)

}