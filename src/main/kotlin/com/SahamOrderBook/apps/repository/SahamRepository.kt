package com.SahamOrderBook.apps.repository

import com.SahamOrderBook.apps.entity.Saham
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SahamRepository : JpaRepository<Saham, String> {
}