package com.SahamOrderBook.apps.repository

import com.SahamOrderBook.apps.entitity.OrderBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderBookRepository : JpaRepository<OrderBook, Long>{

}
