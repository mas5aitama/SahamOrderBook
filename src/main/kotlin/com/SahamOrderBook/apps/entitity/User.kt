package com.SahamOrderBook.apps.entitity

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import javax.persistence.*

@Entity
@Table(name = "\"user\"")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    //@JsonIgnore
    var id: Int? = 0

    @Column(unique = true)
    var email = ""


    @Column
    var password: String = ""
        //@JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder = Argon2PasswordEncoder()
            field = passwordEncoder.encode(value)
        }


    fun comparePassword(password: String): Boolean {
        return Argon2PasswordEncoder().matches(password, this.password)
    }
}
