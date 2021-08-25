package com.example.di

import com.example.domain.core.ThreadContextProvider
import com.example.domain.usecases.FavoriteShowUseCase
import com.example.domain.usecases.ListFavoriteUseCase
import com.example.domain.usecases.MainUseCase
import com.example.domain.usecases.SearchUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {
    single { ThreadContextProvider() }
    factory { (scope: CoroutineScope) -> MainUseCase(scope, get()) }
    factory { (scope: CoroutineScope) -> SearchUseCase(scope, get()) }
    factory { (scope: CoroutineScope) -> FavoriteShowUseCase(scope, get()) }
    factory { (scope: CoroutineScope) -> ListFavoriteUseCase(scope, get()) }
}
