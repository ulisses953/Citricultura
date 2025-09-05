package com.citricultura.citricultura.repository

import com.citricultura.citricultura.entity.Harvest
import org.springframework.data.jpa.repository.JpaRepository

interface HarvestRepository : JpaRepository<Harvest, Long> {
}