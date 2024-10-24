package com.hrsh.analoghh.data.network.services

import com.hrsh.analoghh.data.network.entities.ResponseApi
import retrofit2.http.GET

interface ResponseService {
    @GET("hh.json")
    suspend fun getResponse(): ResponseApi
}