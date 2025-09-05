package com.citricultura.citricultura.entity

import com.citricultura.citricultura.enums.Role
import com.citricultura.citricultura.enums.TipoVinculo
import jakarta.persistence.*

@Entity
@Table(name = "tb_user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val name: String = ""

    val email: String = ""

    val password: String = ""

    @ManyToMany
    @JoinTable(
        name = "user_terrain",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "terrain_id")]
    )
    val terrains: MutableList<Terrain> = mutableListOf()

    @Enumerated(EnumType.STRING)
    val  role : Role = Role.USER

    @Enumerated(EnumType.STRING)
    val tipoVinculo: TipoVinculo = TipoVinculo.OUTRO
}