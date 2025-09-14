package com.citricultura.citricultura.entity

import com.citricultura.citricultura.enums.Role
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

    @Enumerated(EnumType.STRING)
    val  role : Role = Role.USER
}