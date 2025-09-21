package com.citricultura.citricultura.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String = ""

    var size: Double = 0.0

    var location: String = ""

    @Column(name = "lease_value")
    var leaseValue: Double = 0.0

}