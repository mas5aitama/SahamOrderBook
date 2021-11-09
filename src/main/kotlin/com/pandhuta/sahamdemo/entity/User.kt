package com.pandhuta.sahamdemo.entity

import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import javax.persistence.*


@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "ms_user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = 0

    @Column(unique = true, nullable = false)
    var email: String? = null

    @Column(nullable = false)
    var credential: String? = null
        get() = field
        set(value) {
            val passwordEncoder = Argon2PasswordEncoder()
            field = passwordEncoder.encode(value)
        }
}
