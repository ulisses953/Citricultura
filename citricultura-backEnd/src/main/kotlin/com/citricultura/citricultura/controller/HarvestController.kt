package com.citricultura.citricultura.controller

import com.citricultura.citricultura.dto.HarvestDto
import com.citricultura.citricultura.service.HarvestService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/harvest")
class HarvestController(private val HarverstService: HarvestService) {

    @PostMapping()
    fun save(HarvestDTO: HarvestDto): ResponseEntity<HarvestDto> {
        val savedHarvest = HarverstService.save(HarvestDTO)

        return ResponseEntity
            .ok()
            .body(savedHarvest)
    }

    @GetMapping()
    fun findAll(pageable: Pageable): ResponseEntity<Page<HarvestDto>> {
        val harvests = HarverstService.findAll(pageable)
        return ResponseEntity
            .ok()
            .body(harvests)
    }
}