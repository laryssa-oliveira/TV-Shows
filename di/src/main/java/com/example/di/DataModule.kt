package com.example.di

import com.example.data.repository_impl.ShowRepositoryImpl
import com.example.domain.repository.ShowRepository
import org.koin.dsl.module

val dataModule = module {
    single<ShowRepository> { ShowRepositoryImpl(get(), get()) }
}