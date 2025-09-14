package com.citricultura.citricultura.repository

import com.citricultura.citricultura.entity.Fruit
import org.springframework.data.jpa.repository.JpaRepository


interface FruitRepository: JpaRepository<Fruit, Long> {
}