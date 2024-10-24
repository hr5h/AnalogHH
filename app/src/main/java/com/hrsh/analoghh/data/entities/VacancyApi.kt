package com.hrsh.analoghh.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class VacancyApi(
    val lookingNumber: Int?,
    val title: String,
    val address: AddressApi,
    val company: String,
    val experience: ExperienceApi,
    val publishedDate: String,
    val isFavorite: Boolean,
)
