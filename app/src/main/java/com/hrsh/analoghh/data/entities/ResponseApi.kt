package com.hrsh.analoghh.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class ResponseApi(
    val offers: List<OfferApi>,
    val vacancies: List<VacancyApi>,
)
