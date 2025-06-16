package com.example.reciperlogging.dto

import com.example.reciperlogging.enum.EventType
import java.time.LocalDateTime

data class CreationEvent(
    val eventType: EventType,
    val timestamp: LocalDateTime,
    val userId: Long,
    val event: Any?,
    val httpCode: Int,
)
