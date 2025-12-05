package com.example.scheduler.data.local.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converters {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime?): String? = value?.format(formatter)

    @TypeConverter
    fun toLocalDateTime(value: String?): LocalDateTime? = value?.let { LocalDateTime.parse(it, formatter) }

    @TypeConverter
    fun fromIntList(list: List<Int>?): String? = list?.joinToString(separator = ",")

    @TypeConverter
    fun toIntList(value: String?): List<Int>? = value?.takeIf { it.isNotEmpty() }?.split(",")?.map { it.toInt() }
}
