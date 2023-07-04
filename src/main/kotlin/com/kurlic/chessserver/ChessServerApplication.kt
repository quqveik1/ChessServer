package com.kurlic.chessserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class ChessServerApplication

fun main(args: Array<String>) {
    runApplication<ChessServerApplication>(*args)
}
