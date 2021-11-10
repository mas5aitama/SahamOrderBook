package com.pandhuta.sahamdemo.repository

import com.pandhuta.sahamdemo.entity.OrderBook
import com.pandhuta.sahamdemo.entity.Saham
import org.springframework.data.jpa.repository.JpaRepository


/**
 * Spring JPA Repository interface for data Saham.
 *
 * @author Ahmad Fajar <ahmadfajar@gmail.com>
 * @since  03/11/2021, modified: 03/11/2021 22:48
 */
interface SahamRepository : JpaRepository<Saham, String>


interface OrderBookRepository : JpaRepository<OrderBook, Long> {
    fun findBySahamKodeSahamOrderByBidPriceDesc(code: String): List<OrderBook>
}
