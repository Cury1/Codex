package com.example.scheduler.data.repository

import android.content.Context
import androidx.room.Room
import com.example.scheduler.data.local.EventDao
import com.example.scheduler.data.local.SchedulerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SchedulerDatabase {
        return Room.databaseBuilder(
            context,
            SchedulerDatabase::class.java,
            "scheduler.db"
        ).build()
    }

    @Provides
    fun provideEventDao(database: SchedulerDatabase): EventDao = database.eventDao()

    @Provides
    @Singleton
    fun provideScheduleRepository(eventDao: EventDao): ScheduleRepository {
        return DefaultScheduleRepository(eventDao)
    }
}
