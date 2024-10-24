package com.hrsh.analoghh.domain

import com.hrsh.analoghh.data.entities.OfferApi
import com.hrsh.analoghh.data.entities.VacancyApi

data class Response(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>,
)
