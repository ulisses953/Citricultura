package com.citricultura.citricultura.service

import com.citricultura.citricultura.dto.TerrainDtoRequest
import com.citricultura.citricultura.dto.TerrainDtoResponse
import com.citricultura.citricultura.mapper.TerrainMapper
import com.citricultura.citricultura.repository.TerrainRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TerrainService(
    private val terrainRepository: TerrainRepository,
    private val terrainMapper: TerrainMapper
) {

    fun save(terrainDtoRequest: TerrainDtoRequest): TerrainDtoResponse {
        val entity = terrainMapper.toEntity(terrainDtoRequest)

        val savedEntity = terrainRepository.save(entity)

        return terrainMapper.toDto(savedEntity)
    }

    fun findAll(pageable: Pageable): Page<TerrainDtoResponse>{
        return terrainRepository.findAll(pageable).map { terrainMapper.toDto(it) }
    }

}