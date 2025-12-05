package com.example.scheduler.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.scheduler.data.local.converter.Converters
import com.example.scheduler.data.local.dao.EventDao
import com.example.scheduler.data.local.entity.EventEntity

@Database(entities = [EventEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SchedulerDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao

    companion object {
        @Volatile
        private var INSTANCE: SchedulerDatabase? = null

        fun getInstance(context: Context): SchedulerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SchedulerDatabase::class.java,
                    "scheduler.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
