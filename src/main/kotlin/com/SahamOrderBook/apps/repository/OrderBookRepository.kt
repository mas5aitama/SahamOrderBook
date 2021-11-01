package com.SahamOrderBook.apps.repository

import com.SahamOrderBook.apps.entity.OrderBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderBookRepository : JpaRepository<OrderBook, Long>{

     /*@Query(value = "SELECT * FROM ORDER_BOOK", nativeQuery = true)
     fun search(id: Int): List<OrderBook>*/
     /*
     @Query(value = "select * from order_book where bid_lot like %?1% ", nativeQuery = true)
     fun search(s: String, bid_lot: Sort): List<OrderBook>*/


    // fun search(s: Sort): List<OrderBook>

}
