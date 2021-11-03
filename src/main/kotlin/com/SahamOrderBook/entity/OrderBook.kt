package com.SahamOrderBook.entity

import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "order_book")
class OrderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @NotNull
    @Column
    var bidOrder: Double? = null

    @NotNull
    @Column
    var bidLot: Double? = null

    @NotNull
    @Column
    var bidPrice: Double? = null

    @NotNull
    @Column
    var offerPrice: Double? = null

    @NotNull
    @Column
    var offerLot: Double? = null

    @NotNull
    @Column
    var offerOrder: Double? = null
}