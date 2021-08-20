package com.example.di

import com.example.feature_main.presentation.MainViewModel
import com.example.feature_search.presentation.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel() }
    viewModel { SearchViewModel() }

}