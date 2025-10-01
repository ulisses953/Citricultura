package com.citricultura.citricultura.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.Date

@Entity
class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var boxesSold: Int = 0

    @ManyToOne
    @JoinColumn(name = "fruit_id")
    var fruit: Fruit? = null;

    var unitValue : Int = 0

    var totalValue : Int = 0

    var date: Date = Date()

    var paid: Boolean = false
}