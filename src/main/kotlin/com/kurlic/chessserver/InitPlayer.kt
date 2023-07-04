package com.kurlic.chessserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class InitPlayer() {
    @Autowired
    lateinit var playerRepository: PlayerRepository

    @GetMapping("/init/player")
    fun getPlayerID(@RequestParam("androidID") androidID: String): Long {

        var obj = playerRepository.findByAndroidID(androidID)

        if(obj == null) {
            obj = createPlayer(androidID)
        }

        return obj.id!!
    }

    fun createPlayer(androidID: String): Player {
        val player = Player(androidID=androidID);
        return playerRepository.save(player)
    }
}