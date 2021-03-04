package com.missclick.gameclick.dagger2

import android.content.Context
import androidx.room.Room
import com.missclick.gameclick.clickRepository.ClickIRepository
import com.missclick.gameclick.clickRepository.ClickRepository
import com.missclick.gameclick.daoDB.StatSource
import com.missclick.gameclick.daoDB.StatisticsDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module

class AppModule(val context: Context) {

    @Provides
    @Singleton
    fun context() : Context{
        return context
    }

    @Provides

    fun statSource(context: Context) : StatSource{
        return StatSource(
            Room.databaseBuilder(context, StatisticsDataBase::class.java, "db")
                .fallbackToDestructiveMigration()
                .build()
        )
    }

    @Provides

    fun clickIRepository(source: StatSource) : ClickIRepository{
        return ClickRepository(source)
    }




}