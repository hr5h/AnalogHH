package com.hrsh.analoghh.domain.usecases

import com.hrsh.analoghh.data.repositories.ResponseRepository
import com.hrsh.analoghh.domain.entities.Favorite
import javax.inject.Inject

interface SubscribeFavoriteUseCase {
    suspend fun invoke(): List<Favorite>
}

class SubscribeFavoriteUseCaseImpl @Inject constructor(
    private val responseRepository: ResponseRepository
) : SubscribeFavoriteUseCase {

    override suspend fun invoke(): List<Favorite> {
        return responseRepository.getFavorites()
    }
}