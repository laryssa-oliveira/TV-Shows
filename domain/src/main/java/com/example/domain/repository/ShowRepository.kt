package com.example.domain.repository

import com.example.domain.entities.Show
import kotlinx.coroutines.flow.Flow

interface ShowRepository {
    fun getShows() : Flow<List<Show>>
    fun getSearchShows(search: String) : Flow<List<Show>>
    //fun favoriteShow(like: Boolean, show: Show): Flow<Boolean>
    //fun getFavoriteShows() : Flow<List<Show>>

}