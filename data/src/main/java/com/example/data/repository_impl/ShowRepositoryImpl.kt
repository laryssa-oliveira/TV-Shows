package com.example.data.repository_impl

import com.example.data.datasource.LocalDataSource
import com.example.data.datasource.ShowRemoteDataSource
import com.example.domain.entities.Show
import com.example.domain.repository.ShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single

class ShowRepositoryImpl(
    private val showRemoteDataSource: ShowRemoteDataSource,
    private val localDataSource: LocalDataSource
) : ShowRepository{
    override fun getShows() = showRemoteDataSource.getShows()

    override fun getSearchShows(search: String) = showRemoteDataSource.getSearchShows(search)

    override fun favoriteShow(like: Boolean, show: Show) = localDataSource.favoriteShow(like, show)

    override fun getFavoriteShows() = localDataSource.getShowByFavorite()

}