package com.example.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data_local.dao.ShowDao
import com.example.data_local.model.ShowGenreLocal
import com.example.data_local.model.ShowImageLocal
import com.example.data_local.model.ShowLocal

@Database(
    entities = [ShowLocal::class, ShowImageLocal::class, ShowGenreLocal::class],
    version = 1,
    exportSchema = false
)
abstract class ShowsDatabase: RoomDatabase() {

    abstract fun provideShowDao(): ShowDao
}