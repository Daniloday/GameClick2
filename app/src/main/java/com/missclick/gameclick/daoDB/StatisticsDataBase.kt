package com.missclick.gameclick.daoDB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomEntity::class], version = 1)

abstract class StatisticsDataBase : RoomDatabase(){
    abstract fun stat() : StatisticsDao

}