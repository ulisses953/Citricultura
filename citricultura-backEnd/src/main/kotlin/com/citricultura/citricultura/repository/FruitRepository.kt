package com.citricultura.citricultura.repository

import com.citricultura.citricultura.entity.Fruit
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface FruitRepository: JpaRepository<Fruit, Long> {
    fun findByName(name: String): Optional<Fruit>
}