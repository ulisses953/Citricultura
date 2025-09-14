package com.citricultura.citricultura.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var date: LocalDate = LocalDate.now()

    var box: Int = 0

    @ManyToOne()
    @JoinColumn(name = "terrain_id")
    var terrain: Terrain? = null

    @ManyToOne
    @JoinColumn(name = "fruit_id")
    var fruit : Fruit? = null

}
