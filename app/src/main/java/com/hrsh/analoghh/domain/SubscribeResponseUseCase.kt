package com.hrsh.analoghh.domain

import android.util.Log
import com.hrsh.analoghh.data.repositories.ResponseRepository
import kotlinx.coroutines.flow.Flow
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