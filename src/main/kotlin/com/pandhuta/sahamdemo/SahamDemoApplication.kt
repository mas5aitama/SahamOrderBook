package com.pandhuta.sahamdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication(
    scanBasePackages = [
        "com.pandhuta.sahamdemo.controller", "com.pandhuta.sahamdemo.repository"
    ],
    exclude = [SecurityAutoConfiguration::class] // temporary disable SpringSecurity
)
@ConfigurationPropertiesScan("com.pandhuta.sahamdemo.config")
@EntityScan("com.pandhuta.sahamdemo.entity")
class SahamDemoApplication

fun main(args: Array<String>) {
    runApplication<SahamDemoApplication>(*args)
}
