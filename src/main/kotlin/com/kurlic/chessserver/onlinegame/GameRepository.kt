package com.kurlic.chessserver.onlinegame

import com.kurlic.chessserver.player.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface GameRepository : JpaRepository<Game, Long> {

    override fun findById(id: Long) : Optional<Game>
    fun findByPlayer1(id: Long) : Game?
    fun findByPlayer2(id: Long) : Game?

}
fun findOnePlayer(repository: GameRepository, id: Long) : Game?
{
    val id1 = repository.findByPlayer1(id)

    if(id1 != null)
    {
        return id1
    }

    val id2 = repository.findByPlayer2(id)

    if(id2 != null)
    {
        return id2
    }

    return null
}
