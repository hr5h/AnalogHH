package com.hrsh.analoghh.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.hrsh.analoghh.data.storage.AppDatabase
import com.hrsh.analoghh.data.storage.AppDatabase.Companion.DATABASE_NAME
import com.hrsh.analoghh.data.storage.FavoritesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provide(@ApplicationContext context: Context) =
        databaseBuilder(
            context,
            AppDatabase::class.java, DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideFavoritesDao(db: AppDatabase): FavoritesDao = db.operationDao()
}