package com.citricultura.citricultura.mapper

import com.citricultura.citricultura.dto.HarvestDtoRequest
import com.citricultura.citricultura.dto.HarvestDtoResponse
import com.citricultura.citricultura.entity.Fruit
import com.citricultura.citricultura.entity.Harvest
import com.citricultura.citricultura.entity.Terrain
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface HarvestMapper {

    // Entity -> Response: popula nomes do terreno e da fruta
    @Mapping(source = "terrain.name", target = "terrainName")
    @Mapping(source = "fruit.name", target = "fruitName")
    fun toResponse(harvest: Harvest): HarvestDtoResponse

    // Request (com ids) -> Entity: usa helpers para construir entidades apenas com id
    @Mapping(source = "terrainId", target = "terrain")
    @Mapping(source = "fruitId", target = "fruit")
    @Mapping(target = "id", ignore = true)
    fun toEntity(request: HarvestDtoRequest): Harvest

    // Helpers para converter ids em entidades com apenas o id
    fun terrainFromId(id: Long?): Terrain? {
        if (id == null) return null
        val t = Terrain()
        t.id = id
        return t
    }

    fun fruitFromId(id: Long?): Fruit? {
        if (id == null) return null
        val f = Fruit()
        f.id = id
        return f
    }
}
