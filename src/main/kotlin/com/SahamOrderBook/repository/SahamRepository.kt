package com.SahamOrderBook.repository

import com.SahamOrderBook.entity.Saham
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SahamRepository : JpaRepository<Saham, String> {
}