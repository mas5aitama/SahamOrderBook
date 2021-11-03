package com.pandhuta.sahamdemo.config

import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

/**
 * Declare beans configuration.
 *
 * @author Ahmad Fajar <ahmadfajar@gmail.com>
 * @since  04/11/2021, modified: 04/11/2021 2:09
 */
@Configuration(proxyBeanMethods = false)
@EnableCaching
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableJpaAuditing(auditorAwareRef = "auditorAware", modifyOnCreate = false)
class BeansConfig {
    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        config.allowCredentials = true
        config.allowedOrigins = listOf("*")  // e.g. http://domain1.com
        config.allowedHeaders = listOf(
            "Authorization",
            "Accept",
            "Accept-Language",
            "Content-Type",
            "X-Requested-With",
            "Access-Control-Request-Method",
            "Access-Control-Request-Headers",
            "Origin",
            "Last-Modified"
        )
        config.allowedMethods = listOf("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD")
        source.registerCorsConfiguration("/**", config)

        return CorsFilter(source)
    }

}