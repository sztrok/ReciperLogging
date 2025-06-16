package com.example.reciperlogging.component

import com.example.reciperlogging.document.EventLog
import com.example.reciperlogging.dto.RecipeCreatedEvent
import com.example.reciperlogging.service.EventLogService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class EventConsumer(
    private val eventLogService: EventLogService,
) {

    @RabbitListener(queues = ["recipe.events"])
    fun receive(event: RecipeCreatedEvent) {
        println("New event from user: ${event.userId}")
        val log = EventLog(
            eventType = event.eventType,
            timestamp = event.timestamp,
            userId = event.userId,
            data = event.event,
            httpCode = event.httpCode,
        )
        eventLogService.saveEvent(log)
    }
}