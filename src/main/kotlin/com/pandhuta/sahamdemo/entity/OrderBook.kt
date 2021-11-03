package com.pandhuta.sahamdemo.entity

import org.hibernate.Hibernate
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(
    name = "order_book", indexes = [
        Index(name = "order_book_x1", columnList = "kode_saham")
    ]
)
class OrderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

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

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "kode_saham", nullable = false)
    var saham: Saham? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as OrderBook

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 32 * Objects.hash(id)

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , bidOrder = $bidOrder , bidLot = $bidLot , " +
                "bidPrice = $bidPrice , offerPrice = $offerPrice , offerLot = $offerLot , " +
                "offerOrder = $offerOrder )"
    }
}
