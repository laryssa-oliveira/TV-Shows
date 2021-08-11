package com.example.di

import com.example.data.datasource.ShowRemoteDataSource
import com.example.data_remote.datasource.ShowRemoteDataSourceImpl
import com.example.data_remote.shows.api.ApiService
import org.koin.dsl.module

val dataRemoteModule = module {

    single { ApiService.newInstance() }
    single<ShowRemoteDataSource> { ShowRemoteDataSourceImpl(get()) }
}