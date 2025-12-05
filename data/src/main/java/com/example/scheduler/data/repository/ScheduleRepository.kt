package com.example.scheduler.data.repository

import com.example.scheduler.core.model.ScheduleEvent
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {
    fun observeEvents(): Flow<List<ScheduleEvent>>
    suspend fun getEvent(id: Long): ScheduleEvent?
    suspend fun saveEvent(event: ScheduleEvent): Long
    suspend fun deleteEvent(event: ScheduleEvent)
}
