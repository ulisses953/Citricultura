package com.citricultura.citricultura.controller

import com.citricultura.citricultura.dto.FruitDTO
import com.citricultura.citricultura.service.FruitService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping( "api/fruit")
class FruitController(private val fruitService: FruitService) {

    @GetMapping
    fun getFruits(): ResponseEntity<List<FruitDTO>> {
        return ResponseEntity
            .ok()
            .body(fruitService.findAllFruitDtos())
    }

    @PostMapping
    fun saveFruit(fruitDTO: FruitDTO): ResponseEntity<FruitDTO> {
        val savedFruit = fruitService.saveFruit(fruitDTO)
        return ResponseEntity
            .ok()
            .body(savedFruit)
    }

    @DeleteMapping("/{id}")
    fun deleteFruit(@PathVariable id: Long): ResponseEntity<Void> {
        fruitService.deleteFruitById(id)
        return ResponseEntity
            .noContent()
            .build()
    }

}
