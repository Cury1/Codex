package com.example.scheduler.core.model

import kotlinx.datetime.LocalDateTime

/**
 * Simple representation of a scheduled event used across the app layers.
 */
data class ScheduleEvent(
    val id: Long = 0L,
    val title: String,
    val description: String = "",
    val start: LocalDateTime,
    val end: LocalDateTime
)
