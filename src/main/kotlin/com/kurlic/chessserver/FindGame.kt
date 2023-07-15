package com.kurlic.chessserver

import com.kurlic.chessserver.onlinegame.Game
import com.kurlic.chessserver.onlinegame.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class FindGame {

    @Autowired
    lateinit var gameRepository: GameRepository

    private val waitingPlayers = LinkedList<Int>()
    @GetMapping("/find/game/new")
    fun findGameId(playerId: Int): Int {
        if(waitingPlayers.isEmpty())
        {
            waitingPlayers.add(playerId)
            return 0;
        }
        else
        {
            val opponentId = waitingPlayers.first()
            if(opponentId == playerId)
            {
                return 0;
            }
            else
            {
                waitingPlayers.removeFirst();
            }

            val game = Game(player1 = opponentId.toLong(), player2 = playerId.toLong());
            val savedGame = gameRepository.save(game);

            return savedGame.id!!.toInt()
        }
    }

}