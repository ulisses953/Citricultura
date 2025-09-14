package com.citricultura.citricultura.mapper

import com.citricultura.citricultura.dto.FruitDTO
import com.citricultura.citricultura.entity.Fruit
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface FruitMapper {
    fun toDto(entity: Fruit): FruitDTO

    fun toEntity(dto: FruitDTO): Fruit

    fun toDtoList(entities: List<Fruit>): List<FruitDTO>
}
