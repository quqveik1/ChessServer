package com.kurlic.chessserver.onlinegame

import jakarta.persistence.*

@Embeddable
class GameModel {

    @Enumerated(EnumType.STRING)
    var gameStatus: GameStatus = GameStatus.Active1

    var board: String? = null
}
