package com.citricultura.citricultura.controller

import com.citricultura.citricultura.dto.TerrainDto
import com.citricultura.citricultura.service.TerrainService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/terrain")
class TerrainController(private val terrainservice: TerrainService) {

    @PostMapping
    fun save(terrainDto: TerrainDto): ResponseEntity<TerrainDto> {
        val savedTerrain = terrainservice.save(terrainDto)

        return ResponseEntity
            .ok()
            .body(savedTerrain)
    }

    @GetMapping
    fun findAll(pageable: Pageable): ResponseEntity<Page<TerrainDto>> {
        val terrains = terrainservice.findAll(pageable)
        return ResponseEntity
            .ok()
            .body(terrains)
    }

}