package com.pandhuta.sahamdemo.repository

import com.pandhuta.sahamdemo.entity.OrderBook
import com.pandhuta.sahamdemo.entity.Saham
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


/**
 * Spring JPA Repository interface for data Saham.
 *
 * @author Ahmad Fajar <ahmadfajar@gmail.com>
 * @since  03/11/2021, modified: 03/11/2021 22:48
 */
@Repository
interface SahamRepository : JpaRepository<Saham, String>{

}

interface OrderBookRepository : JpaRepository<OrderBook, UUID> {
    //fun findBySahamKodeSahamOrderByBidPriceDesc(code: String): List<OrderBook>
}

