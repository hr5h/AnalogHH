package com.hrsh.analoghh.data.repositories

import android.util.Log
import com.hrsh.analoghh.data.InternetChecker
import com.hrsh.analoghh.data.services.ResponseService
import com.hrsh.analoghh.domain.Offer
import com.hrsh.analoghh.domain.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface ResponseRepository {
    suspend fun getResponse(): Response
}

class ResponseRepositoryImpl @Inject constructor(
    private val responseService: ResponseService,
    private val internetChecker: InternetChecker,
): ResponseRepository {

    override suspend fun getResponse(): Response {
        if(internetChecker.isInternetAvailable()){
            val responseApi = responseService.getResponse()
            return Response(listOf(Offer(title = "UI", link = "link")), emptyList())
        }
        return Response(emptyList(), emptyList())
    }

}