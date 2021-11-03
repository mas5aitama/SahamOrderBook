package com.pandhuta.sahamdemo.controller

import com.pandhuta.sahamdemo.entity.Saham
import com.pandhuta.sahamdemo.repository.SahamRepository
import com.pandhuta.sahamdemo.response.ResponseHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
class SahamController(private val sahamRepository: SahamRepository) {

    @GetMapping(value = ["/saham"])
    fun findAllSaham(): ResponseEntity<Any> {
        return try {
            val result: List<Saham> = sahamRepository.findAll()
            val countTbl: Long = sahamRepository.count()

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

    @GetMapping(value = ["/saham/{id}"])
    fun findSahamById(@PathVariable id: String): ResponseEntity<Any> {
        return try {
            val result: Optional<Saham> = sahamRepository.findById(id)

            ResponseHandler.generateResponse(
                "Success",
                HttpStatus.OK, result, 1
            )
        } catch (e: Exception) {
            ResponseHandler.generateResponse(
                e.message!!, HttpStatus.NOT_FOUND,
                "Data saham tidak ditemukan", 0
            )
        }
    }

    @PostMapping("/saham")
    fun createSaham(@Valid @RequestBody saham: Saham): ResponseEntity<Any> {
        return try {
            val result = sahamRepository.save(saham)

            ResponseHandler.generateResponse(
                "Data saham berhasil disimpan",
                HttpStatus.OK, result, 1
            )
        } catch (e: Exception) {
            ResponseHandler.generateResponse(
                e.message!!, HttpStatus.BAD_REQUEST,
                "Kode saham duplikat", 0
            )
        }
    }

    @DeleteMapping("/saham/{id}")
    fun deleteSaham(@PathVariable id: String): ResponseEntity<Any> {
        return try {
            val found: Saham = sahamRepository.findById(id).get()

            sahamRepository.delete(found)

            ResponseHandler.generateResponse(
                "Data saham berhasil dihapus.",
                HttpStatus.OK, found, 1
            )
        } catch (e: Exception) {
            ResponseHandler.generateResponse(
                e.message!!, HttpStatus.BAD_REQUEST,
                "Delete Failed", 0
            )
        }
    }

    @PutMapping("/saham/{id}")
    fun updateSaham(
        @PathVariable id: String, @Valid @RequestBody saham: Saham,
    ): ResponseEntity<Any> {
        return try {
            val found: Saham = sahamRepository.findById(id).get()
            found.namaSaham = saham.namaSaham
            found.changeValue = saham.changeValue
            found.changePercent = saham.changePercent
            found.lastPrice = saham.lastPrice
            found.priceClose = saham.priceClose
            found.priceOpen = saham.priceOpen
            found.priceHigh = saham.priceHigh
            found.priceLow = saham.priceLow
            found.domesticBuy = saham.domesticBuy
            found.foreignSell = saham.foreignSell

            val result = sahamRepository.save(found)

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