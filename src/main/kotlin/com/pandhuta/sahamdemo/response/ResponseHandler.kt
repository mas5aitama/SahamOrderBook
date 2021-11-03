package com.pandhuta.sahamdemo.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


object ResponseHandler {
    fun generateResponse(
        message: String, status: HttpStatus, response: Any, count: Long
    ): ResponseEntity<Any> {
        val map: MutableMap<String, Any> = HashMap()
        map["message"] = message
        map["status"] = status.value()
        map["data"] = response
        map["count"] = count
        return ResponseEntity(map, status)
    }
}
