package com.citricultura.citricultura.service

import com.citricultura.citricultura.dto.HarvestDtoRequest
import com.citricultura.citricultura.dto.HarvestDtoResponse
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

    fun findAll(pageable: Pageable) : Page<HarvestDtoResponse> {
        return harvestRepository.findAll(pageable).map { harvestMapper.toResponse(it) }
    }

    fun save(request: HarvestDtoRequest) : HarvestDtoResponse {
        val entity: Harvest = harvestMapper.toEntity(request)

        val fruit = fruitRepository.findById(request.fruitId)
        val terrain = terrainRepository.findById(request.terrainId)

        if (fruit.isEmpty)
            throw Exception("Fruit not found: id=${'$'}{request.fruitId}")

        if (terrain.isEmpty)
            throw Exception("Terrain not found: id=${'$'}{request.terrainId}")

        entity.fruit = fruit.get()
        entity.terrain = terrain.get()

        val savedEntity = harvestRepository.save(entity)

        return harvestMapper.toResponse(savedEntity)
    }

}