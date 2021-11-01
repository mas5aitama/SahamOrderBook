package com.SahamOrderBook.apps.contoller


import com.SahamOrderBook.apps.entitity.Saham
import com.SahamOrderBook.apps.repository.SahamRepository
import com.SahamOrderBook.apps.response.ResponseHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = arrayOf("http://localhost:8080"))
class SahamController(private val sahamRepository: SahamRepository) {

    @GetMapping(value = ["/saham"])
    fun getAllSaham(): ResponseEntity<Any> {
        return try {
            val result: List<Saham> = sahamRepository.findAll()
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result, countTbl)

        } catch (e: Exception) {
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Dont Have Data", countTbl)
        }
    }

    @GetMapping(value = ["/saham/{id}"])
    fun getSahamId(@PathVariable id: String): ResponseEntity<Any> {
        return try {
            val result: Optional<Saham> = sahamRepository.findById(id)
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "cant found, your ID", countTbl)
        }
    }

    @PostMapping("/saham")
    fun createSaham(@Valid @RequestBody saham: Saham): ResponseEntity<Any> {
        return try {
            val result = sahamRepository.save(saham)
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse("Save! Succcess", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Not Found Your ID", countTbl)
        }
    }

    @DeleteMapping("/saham/{id}")
    fun deleteSahamId(@PathVariable id: String): ResponseEntity<Any> {
        return try {
            val result: Unit = sahamRepository.deleteById(id)
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse("Deleted! Succcess", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Not Found Your ID", countTbl)
        }
    }

    @PutMapping("/saham/{id}")
    fun updateOrderBook(
        @PathVariable(value = "id", required = false) id: Int, @Valid @RequestBody saham: Saham,
    ): ResponseEntity<Any> {
        return try {
            val result = sahamRepository.save(saham)
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse("Updated", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = sahamRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Updated Failed", countTbl)
        }
    }
}