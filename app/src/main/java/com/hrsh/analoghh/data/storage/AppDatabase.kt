package com.hrsh.analoghh.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FavoriteDb::class],
    version = 1,
    exportSchema = false,
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun operationDao(): FavoritesDao

    companion object {
        const val DATABASE_NAME = "vacancies.db"
    }
}