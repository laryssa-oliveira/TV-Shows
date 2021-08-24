package com.example.feature_search.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.base_feature.ViewState
import com.example.base_feature.mappers.ShowMapper.toShowModel
import com.example.base_feature.model.ShowPresentation
import com.example.base_feature.useCase
import com.example.base_feature.viewState
import com.example.domain.entities.Show
import com.example.domain.usecases.SearchUseCase
import org.koin.core.KoinComponent

class SearchViewModel: ViewModel(), KoinComponent {
    private val searchUseCase: SearchUseCase by useCase()
    private val _showListLiveData by viewState<List<ShowPresentation>>()
    val showListLiveData: LiveData<ViewState<List<ShowPresentation>>> = _showListLiveData
    private var listShow = mutableListOf<Show>()
    private val _searchShow by viewState<List<Show>>()
    val searchShow: LiveData<ViewState<List<Show>>> = _searchShow

    fun search(term: String) {
        searchUseCase(params = SearchUseCase.SearchParams(listShow, term),
            onSuccess = {
                _searchShow.value = ViewState.success(it)
            },
            onError = {
                _searchShow.value = ViewState.error(it)
            })
    }
}