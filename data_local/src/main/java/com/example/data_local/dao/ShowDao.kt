package com.example.data_local.dao

import androidx.room.*
import com.example.data_local.model.ShowLocal

@Dao
interface ShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createShow(companyLocal: ShowLocal)

    @Query("SELECT * FROM shows_table WHERE id = :idCompany")
    suspend fun getShowById(idCompany: Int) : ShowLocal?

    @Query("SELECT * FROM shows_table")
    suspend fun getShowByFavorite() : List<ShowLocal>?

    @Update
    suspend fun updateShow(companyLocal: ShowLocal)

    @Delete
    suspend fun deleteShow(companyLocal: ShowLocal)
}