package com.example.reciperlogging.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("add_recipe_log")
data class AddRecipeLog(
    @Id
    val id: String? = null,
    val eventType: String,
    val timestamp: LocalDateTime,
    val userId: Long,
    val data: Any?,
    val httpCode: Int,
)

@Document("add_account_log")
data class AddAccountLog(
    @Id
    val id: String? = null,
    val eventType: String,
    val timestamp: LocalDateTime,
    val userId: Long,
    val data: Any?,
    val httpCode: Int,
)