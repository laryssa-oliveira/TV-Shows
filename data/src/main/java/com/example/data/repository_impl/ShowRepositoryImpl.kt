package com.example.data.repository_impl

import com.example.data.datasource.ShowRemoteDataSource
import com.example.domain.entities.Show
import com.example.domain.repository.ShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single

class ShowRepositoryImpl(
    private val showRemoteDataSource: ShowRemoteDataSource
) : ShowRepository{
    override fun getShows() = flow {
        emit(showRemoteDataSource.getShows().single())
    }

    override fun getSearchShows(search: String) = showRemoteDataSource.getSearchShows(search)
}