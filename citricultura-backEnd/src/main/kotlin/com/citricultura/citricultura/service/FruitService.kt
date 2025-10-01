package com.citricultura.citricultura.service

import com.citricultura.citricultura.entity.Fruit
import com.citricultura.citricultura.repository.FruitRepository
import com.citricultura.citricultura.dto.FruitDTORequest
import com.citricultura.citricultura.dto.FruitDTOResponse
import com.citricultura.citricultura.mapper.FruitMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FruitService(
    private val fruitRepository: FruitRepository,
    private val fruitMapper: FruitMapper
) {

    fun findAll(pageable: Pageable): Page<FruitDTOResponse> {
       return fruitRepository.findAll(pageable).map { fruitMapper.toResponse(it) }
    }

    fun saveFruit(fruitDTORequest: FruitDTORequest): FruitDTOResponse {
        val entity = fruitMapper.toEntity(fruitDTORequest)

        val savedEntity: Fruit = fruitRepository.save(entity)

        return fruitMapper.toResponse(savedEntity)
    }

    fun deleteFruitById(id: Long) {
        fruitRepository.deleteById(id)
    }

    fun findFruitById(id: Long): FruitDTOResponse? {
        val entity = fruitRepository.findById(id)

        if (entity.isEmpty)
            return null

        return fruitMapper.toResponse(entity.get())
    }


}