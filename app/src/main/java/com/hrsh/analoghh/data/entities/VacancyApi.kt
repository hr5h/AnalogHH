package com.hrsh.analoghh.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class VacancyApi(
    val lookingNumber: Int?,
    val title: String,
    //val address: String,
    val company: String,
    //val experience: String?,
    val publishedDate: String,
    val isFavorite: Boolean,
)
