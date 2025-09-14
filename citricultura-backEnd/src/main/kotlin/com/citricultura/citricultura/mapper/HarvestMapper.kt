package com.citricultura.citricultura.mapper

import com.citricultura.citricultura.dto.HarvestDto
import com.citricultura.citricultura.entity.Fruit
import com.citricultura.citricultura.entity.Harvest
import com.citricultura.citricultura.entity.Terrain
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface HarvestMapper {

    @Mapping(source = "terrain.id", target = "terrainId")
    @Mapping(source = "fruit.id", target = "fruitId")
    fun toDto(harvest: Harvest): HarvestDto

    @Mapping(source = "terrainId", target = "terrain")
    @Mapping(source = "fruitId", target = "fruit")
    fun toEntity(harvestDto: HarvestDto): Harvest

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
