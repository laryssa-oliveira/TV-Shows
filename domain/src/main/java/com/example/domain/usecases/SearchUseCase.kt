package com.example.domain.usecases

import com.example.domain.core.UseCase
import com.example.domain.entities.Show
import com.example.domain.exceptions.MissingParamsException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SearchUseCase(scope: CoroutineScope): UseCase<MutableList<Show>, SearchUseCase.SearchParams>(scope) {
    data class SearchParams(val listShow: MutableList<Show>, val term: String)

    override fun run(params: SearchParams?): Flow<MutableList<Show>> {
        return when {
            params == null -> throw MissingParamsException()
            params.term.isEmpty() -> flowOf(params.listShow)
            else -> searchShow(params.term, params.listShow)
        }
    }

    private fun searchShow(term: String, list: MutableList<Show>): Flow<MutableList<Show>> {
        val shows = list.filter { it.name.toLowerCase().contains(term.toLowerCase()) }.toMutableList()
        return flowOf(shows)
    }
}