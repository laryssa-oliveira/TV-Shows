package com.example.domain.usecases

import com.example.domain.core.UseCase
import com.example.domain.entities.Show
import com.example.domain.repository.ShowRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class ListFavoriteUseCase(scope: CoroutineScope, private val showRepository: ShowRepository) :
    UseCase<List<Show>, Unit>(scope) {

    override fun run(params: Unit?): Flow<List<Show>> {
        return showRepository.getFavoriteShows()
    }
}