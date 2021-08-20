package com.example.feature_search.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.base_feature.ViewState
import com.example.base_feature.mappers.ShowMapper.toShowModel
import com.example.base_feature.model.ShowPresentation
import com.example.base_feature.useCase
import com.example.base_feature.viewState
import com.example.domain.usecases.SearchUseCase
import org.koin.core.KoinComponent

class SearchViewModel: ViewModel(), KoinComponent {
    private val searchUseCase: SearchUseCase by useCase()
    private val _showListLiveData by viewState<List<ShowPresentation>>()
    val showListLiveData: LiveData<ViewState<List<ShowPresentation>>> = _showListLiveData
    private var listShow = mutableListOf<ShowPresentation>()

    fun getSearchShows(search: String) {
        _showListLiveData.value = ViewState.loading(true)
        searchUseCase(
            params = SearchUseCase.SearchParams(search),
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
}