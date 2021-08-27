package com.example.feature_favorite.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.base_feature.ViewState
import com.example.base_feature.mappers.ShowMapper.toModel
import com.example.base_feature.mappers.ShowMapper.toShowModel
import com.example.base_feature.model.ShowPresentation
import com.example.base_feature.useCase
import com.example.base_feature.viewState
import com.example.domain.usecases.FavoriteShowUseCase
import com.example.domain.usecases.ListFavoriteUseCase
import org.koin.core.component.KoinComponent


class FavoriteShowViewModel : ViewModel(), KoinComponent {
    private val listFavoriteUseCase: ListFavoriteUseCase by useCase()
    private val favoriteShowUseCase: FavoriteShowUseCase by useCase()
    private val _showListLiveData by viewState<List<ShowPresentation>>()
    val showListLiveData: LiveData<ViewState<List<ShowPresentation>>> = _showListLiveData
    private var listShowFavorite = mutableListOf<ShowPresentation>()
    private val _favoriteShow by viewState<Unit>()

    fun getFavoriteShows() {
        _showListLiveData.value = ViewState.loading(true)
        listFavoriteUseCase(
            onError = {
                _showListLiveData.value = ViewState.error(it)
                _showListLiveData.value = ViewState.loading(false)
            },
            onSuccess = {
                listShowFavorite.clear()
                listShowFavorite.addAll(it.toShowModel())
                _showListLiveData.value = ViewState.loading(false)
                _showListLiveData.value = ViewState.success(it.toShowModel())
            }
        )
    }

    fun favoriteShows(like: Boolean, show: ShowPresentation) {
        favoriteShowUseCase(params = FavoriteShowUseCase.FavoriteShowParams(like, show.toModel()),
            onSuccess = {
                _favoriteShow.value = ViewState.success(Unit)
            },
            onError = {
                _favoriteShow.value = ViewState.error(it)
            })
    }
}