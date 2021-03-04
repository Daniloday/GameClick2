package com.missclick.gameclick.clickRepository

import com.missclick.gameclick.daoDB.RoomEntity
import com.missclick.gameclick.daoDB.StatSource
import com.missclick.gameclick.data.ModelForDB

class ClickRepository(val source: StatSource) : ClickIRepository {

    override fun insertStats(stat : ModelForDB) {
        val room = RoomEntity(id = stat.id, score = stat.score, name = stat.player)
        source.insertAsync(room)
    }


    override fun appendStats(stat: ModelForDB) {
        val room = RoomEntity(id = stat.id, score = stat.score, name = stat.player)
        source.appendAsync(room)
    }

    override fun delStats(stat: ModelForDB) {
        val room = RoomEntity(id = stat.id, score = stat.score, name = stat.player)
        source.delAsync(room)
    }
}