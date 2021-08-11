package com.example.data_local.datasource

import com.example.data.datasource.LocalDataSource
import com.example.data_local.dao.ShowDao
import com.example.data_local.mappers.LocalModelMappers.toLocalModel
import com.example.data_local.mappers.LocalModelMappers.toModel
import com.example.domain.entities.Show
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl(
    private val showDao: ShowDao
) : LocalDataSource {

    override fun favoriteShow(like: Boolean, show: Show) = flow {
        if (like) {
            showDao.deleteShow(show.toLocalModel())
        } else {
            showDao.createShow(show.apply { favorite = true }.toLocalModel())
        }
        emit(!like)
    }

    override suspend fun getShowById(id: Int) = showDao.getShowById(id)?.toModel()

    override suspend fun getShowByFavorite() = showDao.getShowByFavorite()?.toModel() ?: listOf()

}