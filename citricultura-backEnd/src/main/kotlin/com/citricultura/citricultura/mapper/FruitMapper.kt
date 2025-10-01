package com.citricultura.citricultura.mapper

import com.citricultura.citricultura.dto.FruitDTORequest
import com.citricultura.citricultura.dto.FruitDTOResponse
import com.citricultura.citricultura.entity.Fruit
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface FruitMapper {


    @Mapping(target = "id", ignore = true)
    fun toEntity(fruitDTORequest: FruitDTORequest): Fruit

    fun toResponse(fruit: Fruit): FruitDTOResponse

}
