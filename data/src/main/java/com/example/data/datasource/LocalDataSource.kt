package com.example.data.datasource

import com.example.domain.entities.Show
import kotlinx.coroutines.flow.Flow
import okhttp3.Headers

interface LocalDataSource {

    fun favoriteShow(like: Boolean, show: Show): Flow<Boolean>

    suspend fun getShowById(id: Int): Show?

    suspend fun getShowByFavorite(): List<Show>
}