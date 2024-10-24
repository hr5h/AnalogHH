package com.hrsh.analoghh.data.network.entities

import kotlinx.serialization.Serializable

@Serializable
data class ResponseApi(
    val offers: List<OfferApi>,
    val vacancies: List<VacancyApi>,
)
