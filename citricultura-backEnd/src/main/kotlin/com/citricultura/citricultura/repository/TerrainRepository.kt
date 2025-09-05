package com.citricultura.citricultura.repository

import com.citricultura.citricultura.entity.Terrain
import org.springframework.data.jpa.repository.JpaRepository

interface TerrainRepository : JpaRepository<Terrain, Long> {
}