package com.example.domain.usecases

import com.example.domain.core.UseCase
import com.example.domain.entities.Show
import com.example.domain.exceptions.MissingParamsException
import com.example.domain.repository.ShowRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class FavoriteShowUseCase(scope: CoroutineScope, private val showRepository: ShowRepository) :
    UseCase<Boolean, FavoriteShowUseCase.FavoriteShowParams>(scope) {
    data class FavoriteShowParams(val like: Boolean, val show: Show)

    override fun run(params: FavoriteShowParams?): Flow<Boolean> {
        return when {
            params == null -> throw MissingParamsException()
            else -> showRepository.favoriteShow(params.like, params.show)
        }
    }
}