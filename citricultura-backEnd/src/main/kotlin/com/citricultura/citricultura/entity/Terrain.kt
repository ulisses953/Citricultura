package com.citricultura.citricultura.entity

import jakarta.persistence.*

@Entity
class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String = ""

    var size: Double = 0.0

    var location: String = ""

    var  LeaseValue : Double = 0.0


}