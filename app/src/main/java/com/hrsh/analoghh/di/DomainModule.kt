package com.hrsh.analoghh.di

import com.hrsh.analoghh.domain.SubscribeResponseUseCase
import com.hrsh.analoghh.domain.SubscribeResponseUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindSubscribeTotalUseCase(
        impl: SubscribeResponseUseCaseImpl
    ): SubscribeResponseUseCase
}