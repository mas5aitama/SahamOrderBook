package com.SahamOrderBook.entity

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "saham")
class Saham {
    @Id
    @NotNull
    @Column(nullable = false, length = 10)
    var kodeSaham: String? = null

    @NotNull
    @Column(nullable = false, length = 250)
    var namaSaham: String? = null

    @NotNull
    @Column(nullable = false)
    var hargaTerakhir: Double? = null

    @NotNull
    @Column(nullable = false)
    var change: Double? = null

    @NotNull
    @Column(nullable = false)
    var changePersen: Double? = null

    @NotNull
    @Column(nullable = false)
    var priceClose: Double? = null

    @NotNull
    @Column(nullable = false)
    var priceOpen: Double? = null

    @NotNull
    @Column(nullable = false)
    var priceHigh: Double? = null

    @NotNull
    @Column(nullable = false)
    var priceLow: Double? = null

    @NotNull
    @Column(nullable = false)
    var foreignSale: Double? = null

    @NotNull
    @Column(nullable = false)
    var domesticBuy: Double? = null

    @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    @JoinColumn(name = "kode_saham")
    val orderbook: List<OrderBook>? = ArrayList<OrderBook>()

}