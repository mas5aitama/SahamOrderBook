package com.SahamOrderBook.apps

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer


@SpringBootApplication
//@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class SahamOrderBookApplication : SpringBootServletInitializer()
fun main(args: Array<String>) {
    fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(SahamOrderBookApplication::class.java)
    }
    runApplication<SahamOrderBookApplication>(*args)
}
