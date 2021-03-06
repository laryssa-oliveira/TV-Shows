package com.example.feature_main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.base_feature.ViewState
import com.example.base_feature.mappers.ShowMapper.toModel
import com.example.base_feature.mappers.ShowMapper.toShowModel
import com.example.base_feature.model.ShowPresentation
import com.example.base_feature.useCase
import com.example.base_feature.viewState
import com.example.domain.usecases.FavoriteShowUseCase
import com.example.domain.usecases.MainUseCase
import org.koin.core.component.KoinComponent

class MainViewModel : ViewModel(), KoinComponent {

    private val mainUseCase: MainUseCase by useCase()
    private val favoriteShowUseCase: FavoriteShowUseCase by useCase()
    private val _showListLiveData by viewState<List<ShowPresentation>>()
    val showListLiveData: LiveData<ViewState<List<ShowPresentation>>> = _showListLiveData
    private var listShow = mutableListOf<ShowPresentation>()
    private val _favoriteShow by viewState<Unit>()

    fun getShows() {
        _showListLiveData.value = ViewState.loading(true)
        mainUseCase(
            onError = {
                _showListLiveData.value = ViewState.error(it)
                _showListLiveData.value = ViewState.loading(false)
            },
            onSuccess = {
                listShow.clear()
                listShow.addAll(it.toShowModel())
                _showListLiveData.value = ViewState.loading(false)
                _showListLiveData.value = ViewState.success(it.toShowModel())
            }
        )
    }

    fun favorite(like: Boolean, show: ShowPresentation){
        favoriteShowUseCase(params = FavoriteShowUseCase.FavoriteShowParams(like, show.toModel()),
            onSuccess = {
                _favoriteShow.value = ViewState.success(Unit)
            },
            onError = {
                _favoriteShow.value = ViewState.error(it)
            })
    }
}
