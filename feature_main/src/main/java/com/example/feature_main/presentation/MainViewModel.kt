package com.example.feature_main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.base_feature.ViewState
import com.example.base_feature.useCase
import com.example.base_feature.viewState
import com.example.domain.entities.Show
import com.example.domain.usecases.MainUseCase
import org.koin.core.KoinComponent

class MainViewModel : ViewModel(), KoinComponent {

    private val mainUseCase: MainUseCase by useCase()
    private val _showListLiveData by viewState<List<Show>>()
    val showListLiveData: LiveData<ViewState<List<Show>>> = _showListLiveData
    private var listShow = mutableListOf<Show>()

    fun getShows() {
        _showListLiveData.value = ViewState.loading(true)
        mainUseCase(
            onError = {
                _showListLiveData.value = ViewState.error(it)
                _showListLiveData.value = ViewState.loading(false)
            },
            onSuccess = {
                listShow.clear()
                listShow.addAll(it)
                _showListLiveData.value = ViewState.loading(false)
                _showListLiveData.value = ViewState.success(it)
            }
        )
    }
}
