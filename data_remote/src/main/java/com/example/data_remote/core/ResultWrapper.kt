package com.example.data_remote.core

import com.example.domain.entities.Show
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

sealed class ResultWrapper<out Type>(
    val data: Type? = null,
    val error: Throwable? = null
) {

    class Success<Type>(data: Type) : ResultWrapper<Type>(data), Flow<ResultWrapper<List<Show>>> {
        @InternalCoroutinesApi
        override suspend fun collect(collector: FlowCollector<ResultWrapper<List<Show>>>) {
        }
    }

    class Failure(error: Throwable) : ResultWrapper<Nothing>(error = error)
}