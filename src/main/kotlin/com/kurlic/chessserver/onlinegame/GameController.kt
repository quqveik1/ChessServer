package com.kurlic.chessserver.onlinegame

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController {

    @Autowired
    lateinit var gameRepository: GameRepository

    @GetMapping("/play/game")
    fun checkGameUpdates(@RequestParam("onlineID")onlineID: Long, @RequestParam("message")message: ServerFromClientMessage): ClientFromServerMessage?
    {
        val gameID = findOnePlayer(gameRepository, onlineID)

        if(gameID == null)
        {
            return null
        }

        return null
    }
}