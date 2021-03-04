package com.missclick.gameclick.daoDB

import android.system.Os.stat
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class StatSource(val db : StatisticsDataBase) {

    fun insertAsync(entity: RoomEntity){
        GlobalScope.async {
            db.stat().insertRecord(entity = entity)
        }
    }

    fun appendAsync(entity: RoomEntity){
        GlobalScope.async {
            db.stat().appendStats(entity = entity)
        }
    }

    fun delAsync(entity: RoomEntity){
        GlobalScope.async {
            db.stat().del(entity = entity)
        }
    }
}