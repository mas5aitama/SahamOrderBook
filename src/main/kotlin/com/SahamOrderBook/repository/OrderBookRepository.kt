package com.SahamOrderBook.repository

import com.SahamOrderBook.entity.OrderBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderBookRepository : JpaRepository<OrderBook, Long> {
}
