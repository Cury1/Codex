package com.example.scheduler.core.util

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import java.time.format.DateTimeFormatter

object DateTimeFormatterProvider {
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

    fun formatDateTime(dateTime: LocalDateTime): String {
        return dateTime.toJavaLocalDateTime().format(dateFormatter)
    }
}
