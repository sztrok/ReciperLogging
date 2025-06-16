package com.example.reciperlogging.service

import com.example.reciperlogging.document.EventLog
import com.example.reciperlogging.repository.EventLogRepository
import org.springframework.stereotype.Service

@Service
class EventLogService(
    private val repository: EventLogRepository
) {
    fun saveEvent(event: EventLog) {
        repository.save(event)
            .doOnSuccess { println("Event saved successfully: ${it.eventType}") }
            .subscribe()
    }
}