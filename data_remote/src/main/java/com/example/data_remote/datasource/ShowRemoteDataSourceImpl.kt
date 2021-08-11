package com.example.data_remote.datasource

import com.example.data.datasource.ShowRemoteDataSource
import com.example.data_remote.shows.api.ApiService
import com.example.data_remote.core.wrapResponse
import com.example.data_remote.mappers.fromListResponse
import com.example.domain.entities.Show
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ShowRemoteDataSourceImpl (private val service: ApiService): ShowRemoteDataSource {
    override fun getShows(): Flow<List<Show>> = flow {
        emit(wrapResponse { service.getShows() }.data?.fromListResponse()!!)
    }
}