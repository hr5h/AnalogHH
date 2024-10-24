package com.hrsh.analoghh.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM ${FavoriteDb.FAVORITE_TABLE_NAME}")
    suspend fun getAll(): List<FavoriteDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteDb: FavoriteDb)

    @Delete
    suspend fun delete(favoriteDb: FavoriteDb)
}