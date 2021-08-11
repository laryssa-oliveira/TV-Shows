package com.example.data_local.dao

import androidx.room.*
import com.example.data_local.model.ShowLocal

@Dao
interface ShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createShow(showLocal: ShowLocal)

    @Query("SELECT * FROM shows_table WHERE id = :idShow")
    suspend fun getShowById(idShow: Int) : ShowLocal?

    @Query("SELECT * FROM shows_table")
    suspend fun getShowByFavorite() : List<ShowLocal>?

    @Update
    suspend fun updateShow(showLocal: ShowLocal)

    @Delete
    suspend fun deleteShow(showLocal: ShowLocal)
}