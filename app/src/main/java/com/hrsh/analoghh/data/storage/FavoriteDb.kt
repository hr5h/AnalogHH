package com.hrsh.analoghh.data.storage

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hrsh.analoghh.data.storage.FavoriteDb.Companion.FAVORITE_TABLE_NAME


@Entity(tableName = FAVORITE_TABLE_NAME)
data class FavoriteDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val lookingNumber: Int?,
    val title: String,
    val address: String,
    val company: String,
    val experience: String,
    val publishedDate: String,
) {

    companion object {
        const val FAVORITE_TABLE_NAME = "favorite_table"
    }
}
