package com.kurlic.chessserver

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<Player, Long> {
    fun findByAndroidID(androidId: String): Player?
}