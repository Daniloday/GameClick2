package com.missclick.gameclick.daoDB

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "statistics")

data class RoomEntity(

    @PrimaryKey(autoGenerate = true)

    @NonNull

    @ColumnInfo(name = "id")
    var id : Int,

    @ColumnInfo(name = "player")
    var name : String,

    @ColumnInfo(name = "score")
    var score : Int,

    )
