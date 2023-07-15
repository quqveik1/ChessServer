package com.kurlic.chessserver.onlinegame

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Game(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long? = null,
                val player1: Long,
                val player2: Long)
{
    constructor() : this(player1 = 0, player2 = 0) {

    }
}