package com.citricultura.citricultura.repository

import com.citricultura.citricultura.entity.Terrain
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface TerrainRepository : JpaRepository<Terrain, Long> {
    fun findByName(name: String): Optional<Terrain>
}