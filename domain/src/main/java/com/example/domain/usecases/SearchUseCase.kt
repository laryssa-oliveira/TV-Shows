package com.example.domain.usecases

import com.example.domain.core.UseCase
import com.example.domain.entities.Show
import com.example.domain.exceptions.EmptyFieldException
import com.example.domain.exceptions.MissingParamsException
import com.example.domain.repository.ShowRepository
import kotlinx.coroutines.CoroutineScope

class SearchUseCase(scope: CoroutineScope, private val showRepository: ShowRepository) :
    UseCase<List<Show>, SearchUseCase.SearchParams>(scope) {
    data class SearchParams(val term: String)

    override fun run(params: SearchParams?) = when {
        params == null -> throw MissingParamsException()
        params.term.isEmpty() -> throw EmptyFieldException()
        else -> showRepository.getSearchShows(params.term)
    }
}