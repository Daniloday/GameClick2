package com.missclick.gameclick.daoDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao

interface StatisticsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecord(entity: RoomEntity)

    @Insert
    fun appendStats(entity: RoomEntity)

    @Delete
    fun del(entity: RoomEntity)

}