package com.SahamOrderBook.apps.controller


import com.SahamOrderBook.apps.entity.User
import com.SahamOrderBook.apps.repository.UserRepository
import com.SahamOrderBook.apps.response.ResponseHandler
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.net.URI


@RestController
@RequestMapping("api")
class UserController(private val userRepository: UserRepository) {
    @PostMapping("/register",consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun createUser(@PathVariable user: User, file: MultipartFile, passwordEncoder: Argon2PasswordEncoder): ResponseEntity<Any> {
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
