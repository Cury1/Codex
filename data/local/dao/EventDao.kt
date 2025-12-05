package com.example.scheduler.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.scheduler.data.local.entity.EventEntity
import java.time.LocalDateTime

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: EventEntity): Long

    @Update
    suspend fun update(event: EventEntity)

    @Delete
    suspend fun delete(event: EventEntity)

    @Query("SELECT * FROM events WHERE id = :id")
    suspend fun getById(id: Long): EventEntity?

    @Query("SELECT * FROM events")
    suspend fun getAll(): List<EventEntity>

    @Query(
        "SELECT * FROM events " +
            "WHERE ((startDateTime BETWEEN :start AND :end) " +
            "OR (endDateTime BETWEEN :start AND :end) " +
            "OR (startDateTime <= :start AND endDateTime >= :end)) " +
            "AND (:includeRecurring OR recurrenceRule IS NULL)"
    )
    suspend fun eventsBetween(
        start: LocalDateTime,
        end: LocalDateTime,
        includeRecurring: Boolean = true
    ): List<EventEntity>
}
