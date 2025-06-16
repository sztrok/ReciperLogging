package com.example.reciperlogging.component

import com.example.reciperlogging.document.AddRecipeLog
import com.example.reciperlogging.document.AddAccountLog
import com.example.reciperlogging.dto.CreationEvent
import com.example.reciperlogging.service.EventLogService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class EventConsumer(
    private val eventLogService: EventLogService,
) {

    @RabbitListener(queues = ["recipe.events"])
    fun receiveRecipeCreated(event: CreationEvent) {
        println("New event from user: ${event.userId}")
        val log = AddRecipeLog(
            eventType = event.eventType.toString(),
            timestamp = event.timestamp,
            userId = event.userId,
            data = event.event,
            httpCode = event.httpCode,
        )
        eventLogService.saveEvent(log)
    }

    @RabbitListener(queues = ["account.events"])
    fun receiveAccountCreated(event: CreationEvent) {
        println("New event from user: ${event.userId}")
        val log = AddAccountLog(
            eventType = event.eventType.toString(),
            timestamp = event.timestamp,
            userId = event.userId,
            data = event.event,
            httpCode = event.httpCode,
        )
        eventLogService.saveEvent(log)
    }

}