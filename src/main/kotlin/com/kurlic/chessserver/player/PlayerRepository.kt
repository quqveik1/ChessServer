package com.kurlic.chessserver.player

import com.kurlic.chessserver.player.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<Player, Long> {
    fun findByAndroidID(androidId: String): Player?
}