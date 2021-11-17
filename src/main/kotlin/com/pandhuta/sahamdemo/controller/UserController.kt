package com.pandhuta.sahamdemo.controller

import com.pandhuta.sahamdemo.dto.LoginDTO
import com.pandhuta.sahamdemo.entity.OrderBook
import com.pandhuta.sahamdemo.entity.User
import com.pandhuta.sahamdemo.repository.UserRepository
import com.pandhuta.sahamdemo.response.ResponseHandler
import com.pandhuta.sahamdemo.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid


@RestController
class UserController(private val userRepository: UserRepository, private val userService: UserService) {

    @PostMapping("/register")
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<Any> {
        return try {
            val result = userRepository.save(user)
            val countTbl: Long = userRepository.count()
            ResponseHandler.generateResponse("Save! Succcess", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            ResponseHandler.generateResponse(e.message!!, HttpStatus.NOT_FOUND, "Email Already Exist", 0)
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> {
        val user = this.userService.findByEmail(body.email)
            ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found!")

        if (!user.comparePassword(body.credential)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invalid password!")
        }

        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000)) // 1 day
            // 60 untk 1 menit, 24 untuk per jam, 1000 untuk bbrp kali masukk
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)
        return ResponseEntity.status(HttpStatus.OK).body("Welcome, success login")
    }

    @PostMapping("/logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0
        response.addCookie(cookie)
        return ResponseEntity.status(HttpStatus.OK).body("Welcome, success logout")
    }
}