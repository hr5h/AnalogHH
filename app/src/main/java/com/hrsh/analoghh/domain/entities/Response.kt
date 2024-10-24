package com.hrsh.analoghh.domain.entities

data class Response(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>,
)
