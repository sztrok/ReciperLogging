package com.example.reciperlogging.repository

import com.example.reciperlogging.document.AddAccountLog
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountLogRepository : ReactiveMongoRepository<AddAccountLog, String> {
}