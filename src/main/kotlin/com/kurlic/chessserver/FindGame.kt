package com.kurlic.chessserver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class FindGame {
    private val waitingPlayers = LinkedList<Int>()
    @GetMapping("/find/game")
    fun findGameId(playerId: Int): Int {
        if(waitingPlayers.isEmpty())
        {
            waitingPlayers.add(playerId)
            return 0;
        }
        else {
            val opponentId = waitingPlayers.removeFirst()
            val gameRoomId = UUID.randomUUID().toString().toInt()

            // Here, create your game room and assign these two players to it

            return gameRoomId
        }
    }

}