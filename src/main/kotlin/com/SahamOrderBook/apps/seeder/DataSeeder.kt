package com.SahamOrderBook.apps.seeder

import com.SahamOrderBook.apps.repository.OrderBookRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataSeeder(private val orderBookRepository: OrderBookRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        for (i in 1..20) {
            /*
            val orderBook = OrderBook()

            orderBook.bidLot = Random.nextDouble(1.0, 2.0)
            orderBook.bidOrder = Random.nextDouble(1.0, 2.0)
            orderBook.bidPrice = Random.nextDouble(1.0, 2.0)

            orderBook.offerPrice = Random.nextDouble(1.0, 2.0)
            orderBook.offerOrder = Random.nextDouble(1.0, 2.0)
            orderBook.offerLot = Random.nextDouble(1.0, 2.0)

            orderBookRepository.save(orderBook);
            */
        }

    }
}