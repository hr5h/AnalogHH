package com.hrsh.analoghh.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class OfferApi(
    val title: String,
    val link: String
)
