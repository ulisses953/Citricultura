package com.citricultura.citricultura.controller

import com.citricultura.citricultura.dto.FruitDTORequest
import com.citricultura.citricultura.dto.FruitDTOResponse
import com.citricultura.citricultura.service.FruitService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/fruit")
class FruitController(private val fruitService: FruitService) {

    @GetMapping
    fun findAll(pageable: Pageable): ResponseEntity<Page<FruitDTOResponse>> {
        val fruits = fruitService.findAll(pageable)
        return ResponseEntity
            .ok()
            .body(fruits)
    }

    @PostMapping
    fun save(@RequestBody fruitDTO: FruitDTORequest): ResponseEntity<FruitDTOResponse> {
        val savedFruit = fruitService.saveFruit(fruitDTO)
        return ResponseEntity
            .ok()
            .body(savedFruit)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        fruitService.deleteFruitById(id)
        return ResponseEntity
            .noContent()
            .build()
    }

}
