package com.example.domain.usecases

import com.example.domain.core.UseCase
import com.example.domain.entities.Show
import com.example.domain.exceptions.MissingParamsException
import com.example.domain.repository.ShowRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SearchUseCase(scope: CoroutineScope, private val showRepository: ShowRepository): UseCase<List<Show>, SearchUseCase.SearchParams>(scope) {
    data class SearchParams(val search: String)

    override fun run(params: SearchParams?): Flow<List<Show>> {
        return showRepository.getSearchShows(params!!.search)
    }
}