package com.missclick.gameclick.clickRepository

import com.missclick.gameclick.data.ModelForDB

interface ClickIRepository {
    fun insertStats(stat : ModelForDB)
    fun appendStats(stat : ModelForDB)
    fun delStats(stat : ModelForDB)
    fun nounStat()
}