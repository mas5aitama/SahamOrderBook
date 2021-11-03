package com.SahamOrderBook.entity

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import javax.persistence.*

@Entity
@Table(name = "ms_user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    var id: Long? = 0

    @Column(unique = true, nullable = false)
    var email = ""

    @Column(nullable = false)
    var password: String = ""
        //@JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder = Argon2PasswordEncoder()
            field = passwordEncoder.encode(value)
        }

}

