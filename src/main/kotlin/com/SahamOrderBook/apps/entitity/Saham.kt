package com.SahamOrderBook.apps.entitity

import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "saham")
class Saham {

    @Id
    @NotNull
    @Column
    var kodeSaham: String = ""

    @NotNull
    @Column
    var namaSaham: String? = ""

    @NotNull
    @Column
    var hargaTerakhir: Double? = null

    @NotNull
    @Column
    var change: Double? = null

    @NotNull
    @Column
    var changePersen: Double? = null

    @NotNull
    @Column
    var priceClose: Double? = null

    @NotNull
    @Column
    var priceOpen: Double? = null

    @NotNull
    @Column
    var priceHigh: Double? = null

    @NotNull
    @Column
    var priceLow: Double? = null

    @NotNull
    @Column
    var foreignSale: Double? = null

    @NotNull
    @Column
    var domesticBuy: Double? = null

    @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    @JoinColumn(name = "kodeSaham")
    val orderbook: List<OrderBook>? = ArrayList<OrderBook>()

}