package com.hrsh.analoghh.di

import com.hrsh.analoghh.data.repositories.ResponseRepository
import com.hrsh.analoghh.data.repositories.ResponseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindResponseRepository(
        impl: ResponseRepositoryImpl,
    ): ResponseRepository
}