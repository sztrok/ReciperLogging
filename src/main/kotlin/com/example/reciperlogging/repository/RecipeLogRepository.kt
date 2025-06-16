package com.example.reciperlogging.repository

import com.example.reciperlogging.document.AddRecipeLog
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipeLogRepository : ReactiveMongoRepository<AddRecipeLog, String> {
}