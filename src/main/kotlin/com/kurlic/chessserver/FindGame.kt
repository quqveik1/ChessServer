package com.kurlic.chessserver

import com.kurlic.chessserver.onlinegame.Game
import com.kurlic.chessserver.onlinegame.GameRepository
import com.kurlic.chessserver.onlinegame.findOnePlayer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class FindGame {

    @Autowired
    lateinit var gameRepository: GameRepository

    private val waitingPlayers = LinkedList<Long>()
    @GetMapping("/find/game/new")
    fun findGameId(@RequestParam("onlineID")playerId: Long): Long {

        val potentialGame = findOnePlayer(gameRepository, playerId)
        if(potentialGame != null)
        {
            return potentialGame.id!!
        }

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

            val game = Game(id1 = opponentId, id2 = playerId);
            val savedGame = gameRepository.save(game);

            return savedGame.id!!
        }
    }
    @GetMapping("/find/game/delete")
    fun deleteFromOnline(@RequestParam("onlineID") onlineId: Long) : Boolean
    {
        waitingPlayers.remove(onlineId);


        val game = findOnePlayer(gameRepository, onlineId)

        if(game != null)
        {
            gameRepository.delete(game)
        }
        return true
    }

}