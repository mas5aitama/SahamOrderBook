package com.sahamorderbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

//@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@SpringBootApplication
class SahamOrderBookApplication

fun main(args: Array<String>) {
    runApplication<SahamOrderBookApplication>(*args)
}

//@SpringBootApplication
/*class DemoSahamApplication: SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(DemoSahamApplication::class.java)
}
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(DemoSahamApplication::class.java, *args)
        }
    }*/