package com.hrsh.analoghh.di

import com.hrsh.analoghh.domain.usecases.DeleteFavoriteUseCase
import com.hrsh.analoghh.domain.usecases.DeleteFavoriteUseCaseImpl
import com.hrsh.analoghh.domain.usecases.InsertFavoriteUseCase
import com.hrsh.analoghh.domain.usecases.InsertFavoriteUseCaseImpl
import com.hrsh.analoghh.domain.usecases.SubscribeFavoriteUseCase
import com.hrsh.analoghh.domain.usecases.SubscribeFavoriteUseCaseImpl
import com.hrsh.analoghh.domain.usecases.SubscribeResponseUseCase
import com.hrsh.analoghh.domain.usecases.SubscribeResponseUseCaseImpl
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

    @Binds
    abstract fun bindSubscribeFavoriteUseCase(
        impl: SubscribeFavoriteUseCaseImpl
    ): SubscribeFavoriteUseCase

    @Binds
    abstract fun bindInsertFavoriteUseCase(
        impl: InsertFavoriteUseCaseImpl
    ): InsertFavoriteUseCase

    @Binds
    abstract fun bindDeleteFavoriteUseCase(
        impl: DeleteFavoriteUseCaseImpl
    ): DeleteFavoriteUseCase
}