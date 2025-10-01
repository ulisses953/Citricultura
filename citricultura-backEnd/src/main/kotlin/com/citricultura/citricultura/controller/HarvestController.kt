package com.citricultura.citricultura.controller

import com.citricultura.citricultura.dto.HarvestDtoRequest
import com.citricultura.citricultura.dto.HarvestDtoResponse
import com.citricultura.citricultura.service.HarvestService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/harvest")
class HarvestController(private val HarverstService: HarvestService) {

    @PostMapping
    fun save(@RequestBody request: HarvestDtoRequest): ResponseEntity<HarvestDtoResponse> {
        val savedHarvest = HarverstService.save(request)
        return ResponseEntity.ok(savedHarvest)
    }

    @GetMapping
    fun findAll(pageable: Pageable): ResponseEntity<Page<HarvestDtoResponse>> {
        val harvests = HarverstService.findAll(pageable)
        return ResponseEntity.ok(harvests)
    }

}