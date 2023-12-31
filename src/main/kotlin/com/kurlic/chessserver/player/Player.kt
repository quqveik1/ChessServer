package com.kurlic.chessserver.player

import jakarta.persistence.Entity
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue


@Entity
data class Player(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val androidID: String

)
{
    constructor() : this(androidID = "") {
    }

}
