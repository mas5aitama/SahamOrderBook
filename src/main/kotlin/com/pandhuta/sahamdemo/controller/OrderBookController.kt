package com.pandhuta.sahamdemo.controller

import com.pandhuta.sahamdemo.entity.OrderBook
import com.pandhuta.sahamdemo.repository.OrderBookRepository
import com.pandhuta.sahamdemo.repository.SahamRepository
import com.pandhuta.sahamdemo.response.ResponseHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
class OrderBookController(private val orderBookRepository: OrderBookRepository,
                          private val sahamRepository: SahamRepository) {

    @GetMapping(value = ["/order-book"])
    fun findAllOrderBook(): ResponseEntity<Any> {
        return try {
            val result: List<OrderBook> = orderBookRepository.findAll()
            val countTbl: Long = orderBookRepository.count()

            ResponseHandler.generateResponse(
                "Success",
                HttpStatus.OK, result, countTbl
            )
        } catch (e: Exception) {
            ResponseHandler.generateResponse(
                e.message!!, HttpStatus.INTERNAL_SERVER_ERROR,
                "Error while processing your request", 0
            )
        }
    }

    @GetMapping(value = ["/order-book/{id}"])
    fun findOrderBookById(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            val result: Optional<OrderBook> = orderBookRepository.findById(id)

            ResponseHandler.generateResponse(
                "Success",
                HttpStatus.OK, result, 1
            )
        } catch (e: Exception) {
            ResponseHandler.generateResponse(
                e.message!!, HttpStatus.NOT_FOUND,
                "Data OrderBook tidak ditemukan", 0
            )
        }
    }

    @GetMapping(value = ["/order-book/saham/{code}"])
    fun findOrderBookByKodeSaham(@PathVariable code: String): ResponseEntity<Any> {
        return try {
            val result: List<OrderBook> = orderBookRepository.findBySahamKodeSahamOrderByBidPriceDesc(code)

            ResponseHandler.generateResponse(
                "Success",
                HttpStatus.OK, result, result.count().toLong()
            )
        } catch (e: Exception) {
            ResponseHandler.generateResponse(
                e.message!!, HttpStatus.NOT_FOUND,
                "Data saham tidak ditemukan", 0
            )
        }
    }

    @PostMapping("/order-book/{kode}")
    fun createOrderBook(@PathVariable kode: String, @Valid @RequestBody newOrderBook: OrderBook): ResponseEntity<Any> {
        return try {
            val parent = sahamRepository.findById(kode).get()
            newOrderBook.saham = parent
            val result = orderBookRepository.save(newOrderBook)
            ResponseHandler.generateResponse(
                "Data OrderBook berhasil disimpan",
                HttpStatus.OK, result, 1
            )
        } catch (e: Exception) {
            ResponseHandler.generateResponse(
                e.message!!, HttpStatus.BAD_REQUEST,
                "OrderBook duplicated", 0
            )
        }
    }

    @DeleteMapping("/order-book/{id}")
    fun deleteOrderBook(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            val found: OrderBook = orderBookRepository.findById(id).get()

            orderBookRepository.delete(found)

            ResponseHandler.generateResponse(
                "Data OrderBook berhasil dihapus.",
                HttpStatus.OK, found, 1
            )
        } catch (e: Exception) {
            ResponseHandler.generateResponse(
                e.message!!, HttpStatus.BAD_REQUEST,
                "Delete Failed", 0
            )
        }
    }

    @PutMapping("/order-book/{id}")
    fun updateOrderBook(
        @PathVariable("id") id: Long, @Valid @RequestBody orderBook: OrderBook,
    ): ResponseEntity<Any> {
        return try {
            val found: OrderBook = orderBookRepository.findById(id).get()
            found.bidOrder = orderBook.bidOrder
            found.bidLot = orderBook.bidLot
            found.bidPrice = orderBook.bidPrice
            found.offerPrice = orderBook.offerPrice
            found.offerLot = orderBook.offerLot
            found.offerOrder = orderBook.offerOrder
            // TODO: Code pada bagian ini diperbaiki.
            //  Sebagai contoh, lihat method: updateSaham()
            val result = orderBookRepository.save(orderBook)
            ResponseHandler.generateResponse(
                "Data saham berhasil diperbarui",
                HttpStatus.OK, result, 1
            )
        } catch (e: Exception) {
            ResponseHandler.generateResponse(
                e.message!!, HttpStatus.BAD_REQUEST,
                "Update Failed", 0
            )
        }
    }
}