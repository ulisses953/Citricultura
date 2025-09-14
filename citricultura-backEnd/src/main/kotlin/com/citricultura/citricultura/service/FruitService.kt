package com.citricultura.citricultura.service

import com.citricultura.citricultura.entity.Fruit
import com.citricultura.citricultura.repository.FruitRepository
import com.citricultura.citricultura.dto.FruitDTO
import com.citricultura.citricultura.mapper.FruitMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FruitService(
    private val fruitRepository: FruitRepository,
    private val fruitMapper: FruitMapper
) {

    fun findAllFruitDtos(): List<FruitDTO> {
        val entities = fruitRepository.findAll()
        return fruitMapper.toDtoList(entities)
    }

    fun saveFruit(fruitDTO: FruitDTO): FruitDTO {
        val entity: Fruit = fruitMapper.toEntity(fruitDTO)

        val savedEntity = fruitRepository.save(entity)

        return fruitMapper.toDto(savedEntity)
    }

    fun deleteFruitById(id: Long) {
        fruitRepository.deleteById(id)
    }

    fun findFruitById(id: Long): FruitDTO? {
        val entity = fruitRepository.findById(id)

        if (entity.isEmpty)
            return null

        return fruitMapper.toDto(entity.get())
    }

    fun findAll(pageable: Pageable): Page<FruitDTO> {
        return fruitRepository.findAll(pageable).map { fruitMapper.toDto(it) }
    }


}