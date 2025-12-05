package com.example.scheduler.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [EventEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class SchedulerDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}
