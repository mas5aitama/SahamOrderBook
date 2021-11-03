package com.pandhuta.sahamdemo.repository

import com.pandhuta.sahamdemo.entity.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository : JpaRepository<User, Int>
