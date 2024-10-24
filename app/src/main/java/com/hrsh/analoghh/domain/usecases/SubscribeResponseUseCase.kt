package com.hrsh.analoghh.domain.usecases

import com.hrsh.analoghh.data.repositories.ResponseRepository
import com.hrsh.analoghh.domain.entities.Response
import javax.inject.Inject

interface SubscribeResponseUseCase {
    suspend fun invoke(): Response
}

class SubscribeResponseUseCaseImpl @Inject constructor(
    private val responseRepository: ResponseRepository
) : SubscribeResponseUseCase {

    override suspend fun invoke(): Response {
        return responseRepository.getResponse()
    }
}