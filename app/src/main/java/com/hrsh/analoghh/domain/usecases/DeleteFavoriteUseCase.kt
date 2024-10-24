package com.hrsh.analoghh.domain.usecases

import com.hrsh.analoghh.data.repositories.ResponseRepository
import com.hrsh.analoghh.domain.entities.Favorite
import javax.inject.Inject

interface DeleteFavoriteUseCase {
    suspend fun invoke(favorite: Favorite)
}

class DeleteFavoriteUseCaseImpl @Inject constructor(
    private val responseRepository: ResponseRepository
) : DeleteFavoriteUseCase {

    override suspend fun invoke(favorite: Favorite) {
        responseRepository.deleteFavorite(favorite)
    }
}