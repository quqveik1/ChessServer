package com.kurlic.chessserver.onlinegame

import jakarta.persistence.*

@Entity
data class Game(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long? = null,
                val player1: Long,
                val player2: Long,
                @Embedded val gameModel: GameModel)
{
    constructor() : this(player1 = 0, player2 = 0, gameModel = GameModel()) {

    }

    constructor(id1: Long, id2: Long) : this(player1 = id1, player2 = id2, gameModel = GameModel()) {

    }
}