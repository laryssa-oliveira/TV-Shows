package com.example.data_local.core

import android.app.Application
import androidx.room.Room
import com.example.data_local.database.ShowsDatabase

object DatabaseConfiguration {

    fun createDatabase(application: Application) = Room.databaseBuilder(
        application,
        ShowsDatabase::class.java,
        "shows_database"
    ).build()

    fun provideShowDao(database: ShowsDatabase) = database.provideShowDao()

}