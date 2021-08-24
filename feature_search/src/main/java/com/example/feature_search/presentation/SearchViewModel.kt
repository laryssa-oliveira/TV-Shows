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
    private val _searchShow by viewState<List<ShowPresentation>>()
    val searchShow: LiveData<ViewState<List<ShowPresentation>>> = _searchShow

    fun search(term: String) {
        searchUseCase(params = SearchUseCase.SearchParams(term),
            onSuccess = {
                _searchShow.value = ViewState.success(it.toShowModel())
            },
            onError = {
                _searchShow.value = ViewState.error(it)
            })
    }
}