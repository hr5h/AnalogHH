package com.hrsh.analoghh.data.network.entities

import kotlinx.serialization.Serializable

@Serializable
data class OfferApi(
    val id: String?,
    val title: String,
    val link: String,
    val button: ButtonApi?
)
