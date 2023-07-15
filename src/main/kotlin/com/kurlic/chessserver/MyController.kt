package com.kurlic.chessserver

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

data class Action(var name: String)
data class Event(var name: String)
@Controller
class MyController {
    @MessageMapping("/action")
    @SendTo("/topic/events")
    fun handleAction(action: Action): Event {
        return Event("Event for action: " + action.toString())
    }
}
