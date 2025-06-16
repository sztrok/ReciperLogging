package com.example.reciperlogging.dto

import java.time.LocalDateTime

data class RecipeCreatedEvent(
    val eventType: String,
    val timestamp: LocalDateTime,
    val userId: Long,
    val event: Map<String, Any>,
    val httpCode: Int,
)
