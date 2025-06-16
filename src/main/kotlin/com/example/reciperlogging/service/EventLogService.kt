package com.example.reciperlogging.service

import com.example.reciperlogging.document.AddAccountLog
import com.example.reciperlogging.document.AddRecipeLog
import com.example.reciperlogging.repository.AccountLogRepository
import com.example.reciperlogging.repository.RecipeLogRepository
import org.springframework.stereotype.Service

@Service
class EventLogService(
    private val recipeRepo: RecipeLogRepository,
    private val accountRepo: AccountLogRepository
) {
    fun saveEvent(event: AddRecipeLog) {
        recipeRepo.save(event)
            .doOnSuccess { println("Recipe event saved successfully: ${it.eventType}") }
            .subscribe()
    }

    fun saveEvent(event: AddAccountLog) {
        accountRepo.save(event)
            .doOnSuccess { println("Account event saved successfully: ${it.eventType}") }
            .subscribe()
    }
}