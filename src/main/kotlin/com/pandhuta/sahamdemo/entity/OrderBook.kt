package com.pandhuta.sahamdemo.entity

import org.hibernate.Hibernate
import org.hibernate.annotations.*
import org.hibernate.annotations.Cache
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(
    name = "order_book", indexes = [
        Index(name = "order_book_x1", columnList = "kode_saham")
    ]
)
class OrderBook(

    @get:[NotBlank(message = "Kelurahan.name.NotEmpty")]
    @NotNull
    @Column
    var bidOrder: Double? = null,

    @NotNull
    @Column
    var bidLot: Double? = null,

    @NotNull
    @Column
    var bidPrice: Double? = null,

    @NotNull
    @Column
    var offerPrice: Double? = null,

    @NotNull
    @Column
    var offerLot: Double? = null,

    @NotNull
    @Column
    var offerOrder: Double? = null,

    /*@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "kode_saham", nullable = false)
    var saham: Saham? = null*/

/*    @ManyToOne(optional = false, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "kode_saham", nullable = false)
    var saham: Saham? = null*/
) {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "orderBookId", nullable = false)
    var orderBookId: UUID? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrderBook

        if (bidOrder != other.bidOrder) return false
        if (orderBookId != other.orderBookId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = bidOrder?.hashCode() ?: 0
        result = 31 * result + (orderBookId?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "OrderBook(bidLot=$bidLot, orderBookId=$orderBookId)"
    }
}