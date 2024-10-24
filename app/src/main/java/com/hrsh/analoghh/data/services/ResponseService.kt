package com.hrsh.analoghh.data.services

import com.hrsh.analoghh.data.entities.ResponseApi
import retrofit2.http.GET

interface ResponseService {
    @GET("hh.json")
    suspend fun getResponse(): ResponseApi
}