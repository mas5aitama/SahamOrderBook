package com.SahamOrderBook.apps

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])class SahamOrderBookApplication
fun main(args: Array<String>) {
	runApplication<SahamOrderBookApplication>(*args)
}
