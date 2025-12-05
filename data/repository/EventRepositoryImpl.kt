package com.example.scheduler.data.repository

import com.example.scheduler.data.local.dao.EventDao
import com.example.scheduler.data.local.entity.EventEntity
import java.time.LocalDateTime

class EventRepositoryImpl(private val eventDao: EventDao) : EventRepository {
    override suspend fun getEvent(id: Long): EventEntity? = eventDao.getById(id)

    override suspend fun getEventsBetween(
        start: LocalDateTime,
        end: LocalDateTime,
        includeRecurring: Boolean
    ): List<EventEntity> = eventDao.eventsBetween(start, end, includeRecurring)

    override suspend fun getAllEvents(): List<EventEntity> = eventDao.getAll()

    override suspend fun saveEvent(event: EventEntity): Long = eventDao.insert(event)

    override suspend fun updateEvent(event: EventEntity) {
        eventDao.update(event)
    }

    override suspend fun deleteEvent(event: EventEntity) {
        eventDao.delete(event)
    }
}
