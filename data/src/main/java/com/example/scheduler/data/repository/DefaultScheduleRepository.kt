package com.example.scheduler.data.repository

import com.example.scheduler.core.model.ScheduleEvent
import com.example.scheduler.data.local.EventDao
import com.example.scheduler.data.local.toEntity
import com.example.scheduler.data.local.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultScheduleRepository @Inject constructor(
    private val eventDao: EventDao
) : ScheduleRepository {

    override fun observeEvents(): Flow<List<ScheduleEvent>> {
        return eventDao.observeEvents().map { events -> events.map { it.toModel() } }
    }

    override suspend fun getEvent(id: Long): ScheduleEvent? {
        return eventDao.getById(id)?.toModel()
    }

    override suspend fun saveEvent(event: ScheduleEvent): Long {
        return eventDao.upsert(event.toEntity())
    }

    override suspend fun deleteEvent(event: ScheduleEvent) {
        eventDao.delete(event.toEntity())
    }
}
