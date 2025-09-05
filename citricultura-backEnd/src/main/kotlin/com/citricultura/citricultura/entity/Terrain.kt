package com.citricultura.citricultura.entity

import jakarta.persistence.*

@Entity
class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val name: String = ""

    @ManyToMany(mappedBy = "terrains")
    val users: MutableList<User> = mutableListOf()


}