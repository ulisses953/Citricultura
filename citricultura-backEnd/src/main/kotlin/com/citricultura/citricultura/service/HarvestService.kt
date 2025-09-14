package com.citricultura.citricultura.service

import com.citricultura.citricultura.dto.HarvestDto
import com.citricultura.citricultura.entity.Harvest
import com.citricultura.citricultura.mapper.HarvestMapper
import com.citricultura.citricultura.repository.FruitRepository
import com.citricultura.citricultura.repository.HarvestRepository
import com.citricultura.citricultura.repository.TerrainRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class HarvestService(
    private val harvestRepository: HarvestRepository,
    private val fruitRepository: FruitRepository,
    private val terrainRepository: TerrainRepository,
    private val harvestMapper: HarvestMapper
) {

    fun findAll(pageable: Pageable) : Page<HarvestDto> {
        return harvestRepository.findAll(pageable).map { harvestMapper.toDto(it) }
    }

    fun save(harvestDto: HarvestDto) : HarvestDto {
        val entity: Harvest = harvestMapper.toEntity(harvestDto)

        val fruit = fruitRepository.findById(harvestDto.fruitId)
        val terrain = terrainRepository.findById(harvestDto.terrainId)

        if (fruit.isEmpty)
            throw Exception("Fruit not found")

        if (terrain.isEmpty)
            throw Exception("Terrain not found")

        entity.fruit = fruit.get()
        entity.terrain = terrain.get()

        val savedEntity = harvestRepository.save(entity)

        return harvestMapper.toDto(savedEntity)

    }




}