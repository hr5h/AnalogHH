package com.hrsh.analoghh.domain.usecases

import com.hrsh.analoghh.data.repositories.ResponseRepository
import com.hrsh.analoghh.domain.entities.Favorite
import javax.inject.Inject

interface InsertFavoriteUseCase {
    suspend fun invoke(favorite: Favorite)
}

class InsertFavoriteUseCaseImpl @Inject constructor(
    private val responseRepository: ResponseRepository
) : InsertFavoriteUseCase {

    override suspend fun invoke(favorite: Favorite) {
        responseRepository.postFavorite(favorite)
    }
}