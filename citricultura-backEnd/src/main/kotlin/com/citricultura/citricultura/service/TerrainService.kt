package com.citricultura.citricultura.service

import com.citricultura.citricultura.dto.TerrainDto
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

    fun save(terrainDto: TerrainDto): TerrainDto {
        val entity = terrainMapper.toEntity(terrainDto)

        val savedEntity = terrainRepository.save(entity)

        return terrainMapper.toDto(savedEntity)
    }

    fun findAll(pageable: Pageable): Page<TerrainDto>{
        return terrainRepository.findAll(pageable).map { terrainMapper.toDto(it) }
    }
}