package com.example.di

import com.example.domain.core.ThreadContextProvider
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {
    single { ThreadContextProvider() }

}
