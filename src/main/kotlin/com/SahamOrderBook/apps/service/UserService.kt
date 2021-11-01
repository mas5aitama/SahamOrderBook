package com.SahamOrderBook.apps.service

import com.SahamOrderBook.apps.entity.User
import com.SahamOrderBook.apps.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UserService(private val userRepository: UserRepository) {

    fun setProfilePicture(id: Int, file: MultipartFile){

        val user : User = userRepository.findById(id).orElseThrow()
        user.profilePicture = file.bytes
        userRepository.save(user)

    }
}



