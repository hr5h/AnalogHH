package com.hrsh.analoghh.data.repositories

import com.hrsh.analoghh.data.utils.InternetChecker
import com.hrsh.analoghh.data.mappers.ResponseApiToDomainMapper
import com.hrsh.analoghh.data.services.ResponseService
import com.hrsh.analoghh.domain.entities.Response
import javax.inject.Inject

interface ResponseRepository {
    suspend fun getResponse(): Response
}

class ResponseRepositoryImpl @Inject constructor(
    private val responseService: ResponseService,
    private val internetChecker: InternetChecker,
    private val mapper: ResponseApiToDomainMapper
): ResponseRepository {

    override suspend fun getResponse(): Response {
        if(internetChecker.isInternetAvailable()){
            val responseApi = responseService.getResponse()
            return mapper.invoke(responseApi)
        }

        return Response(emptyList(), emptyList())
    }

}