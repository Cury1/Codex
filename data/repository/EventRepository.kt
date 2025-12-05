package com.example.scheduler.data.repository

import com.example.scheduler.data.local.entity.EventEntity
import java.time.LocalDateTime

interface EventRepository {
    suspend fun getEvent(id: Long): EventEntity?

    suspend fun getEventsBetween(
        start: LocalDateTime,
        end: LocalDateTime,
        includeRecurring: Boolean = true
    ): List<EventEntity>

    suspend fun getAllEvents(): List<EventEntity>

    suspend fun saveEvent(event: EventEntity): Long

    suspend fun updateEvent(event: EventEntity)

    suspend fun deleteEvent(event: EventEntity)
}
