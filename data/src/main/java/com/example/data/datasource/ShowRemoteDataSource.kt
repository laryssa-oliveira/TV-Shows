package com.example.data.datasource

import com.example.domain.entities.Show
import kotlinx.coroutines.flow.Flow

interface ShowRemoteDataSource {
    fun getShows() : Flow<List<Show>>
}