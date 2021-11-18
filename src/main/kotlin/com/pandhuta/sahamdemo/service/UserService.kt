package com.pandhuta.sahamdemo.service

import com.pandhuta.sahamdemo.entity.User
import com.pandhuta.sahamdemo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun findByEmail(email: String): User? {
        return this.userRepository.findByEmail(email)
    }
}