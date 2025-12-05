package com.example.scheduler.data.local

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import kotlinx.datetime.toKotlinLocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeConverter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromString(raw: String?): LocalDateTime? = raw?.let {
        java.time.LocalDateTime.parse(it, formatter).toKotlinLocalDateTime()
    }

    @TypeConverter
    fun toString(value: LocalDateTime?): String? = value?.toJavaLocalDateTime()?.format(formatter)
}
