package com.citricultura.citricultura.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val date: LocalDate = LocalDate.now()

    val box: Int = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terrain_id")
    val terrain: Terrain? = null


}
