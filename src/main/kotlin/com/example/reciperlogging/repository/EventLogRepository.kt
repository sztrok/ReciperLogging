package com.example.reciperlogging.repository

import com.example.reciperlogging.document.EventLog
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EventLogRepository : ReactiveMongoRepository<EventLog, String> {
}