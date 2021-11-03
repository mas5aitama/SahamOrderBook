package com.SahamOrderBook.controller


import com.SahamOrderBook.entity.User
import com.SahamOrderBook.repository.UserRepository
import com.SahamOrderBook.response.ResponseHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@CrossOrigin(origins = ["http://localhost:8080"])
class UserController(private val userRepository: UserRepository) {
    @PostMapping("/register")
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<Any> {
        return try {
            val result = userRepository.save(user)
            val countTbl: Long = userRepository.count()
            ResponseHandler.generateResponse("Save! Succcess", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = userRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Email Already Exist", countTbl)
        }
    }
}