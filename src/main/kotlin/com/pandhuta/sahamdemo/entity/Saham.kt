package com.pandhuta.sahamdemo.entity

import org.hibernate.Hibernate
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull


@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "ms_saham")
class Saham {
    @Id
    @NotNull
    @Column(nullable = false, length = 10, updatable = false)
    var kodeSaham: String? = null

    @NotNull
    @Column(nullable = false, length = 250)
    var namaSaham: String? = null

    @NotNull
    @Column(nullable = false)
    var lastPrice: Double? = null

    @NotNull
    @Column(nullable = false)
    var changeValue: Double? = null

    @NotNull
    @Column(nullable = false)
    var changePercent: Double? = null

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

    @Column
    var foreignSell: Double? = null

    @Column
    var domesticBuy: Double? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Saham

        return Objects.equals(kodeSaham, other.kodeSaham) && Objects.equals(namaSaham, other.namaSaham)
    }

    override fun hashCode(): Int = 32 + Objects.hash(kodeSaham, namaSaham) // javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(kodeSaham = $kodeSaham , namaSaham = $namaSaham , " +
                "lastPrice = $lastPrice , changeValue = $changeValue , " +
                "changePercent = $changePercent , priceClose = $priceClose , " +
                "priceOpen = $priceOpen , priceHigh = $priceHigh , priceLow = $priceLow )"
    }

}
