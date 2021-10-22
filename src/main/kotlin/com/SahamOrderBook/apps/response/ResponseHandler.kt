package com.SahamOrderBook.apps.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


object ResponseHandler {
    fun generateResponse(message: String, status: HttpStatus, responseObj: Any, countTbl:Long

    ): ResponseEntity<Any> {
        val map: MutableMap<String, Any> = HashMap()
        map["message"] = message
        map["status"] = status.value()
        map["data"] = responseObj
        map["countOfTable"] = countTbl
        return ResponseEntity(map, status)
    }
}