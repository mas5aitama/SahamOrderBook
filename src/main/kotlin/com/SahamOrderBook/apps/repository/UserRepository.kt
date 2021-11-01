package com.SahamOrderBook.apps.repository

 import com.SahamOrderBook.apps.entity.User
 import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int> {
}