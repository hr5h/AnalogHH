package com.hrsh.analoghh.di

import com.hrsh.analoghh.data.services.ResponseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val client: OkHttpClient = OkHttpClient.Builder().build()

        return Retrofit
            .Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideResponseService(retrofit: Retrofit): ResponseService {
        return retrofit.create(ResponseService::class.java)
    }

    val BASE_URL = "https://raw.githubusercontent.com/hr5h/hrsh.github.io/refs/heads/main/api/"
}