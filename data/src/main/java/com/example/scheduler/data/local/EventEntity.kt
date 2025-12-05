package com.example.scheduler.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.scheduler.core.model.ScheduleEvent
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val title: String,
    val description: String,
    val start: LocalDateTime,
    val end: LocalDateTime
)

fun EventEntity.toModel(): ScheduleEvent = ScheduleEvent(
    id = id,
    title = title,
    description = description,
    start = start,
    end = end
)

fun ScheduleEvent.toEntity(): EventEntity = EventEntity(
    id = id,
    title = title,
    description = description,
    start = start,
    end = end
)
