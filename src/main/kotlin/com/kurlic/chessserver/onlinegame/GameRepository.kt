package com.kurlic.chessserver.onlinegame

import com.kurlic.chessserver.player.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface GameRepository : JpaRepository<Game, Long> {

    override fun findById(id: Long) : Optional<Game>

}