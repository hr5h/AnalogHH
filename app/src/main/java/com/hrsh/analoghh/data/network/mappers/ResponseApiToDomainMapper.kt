package com.hrsh.analoghh.data.network.mappers

import com.hrsh.analoghh.data.network.entities.ResponseApi
import com.hrsh.analoghh.domain.entities.Offer
import com.hrsh.analoghh.domain.entities.Response
import com.hrsh.analoghh.domain.entities.Vacancy
import javax.inject.Inject

class ResponseApiToDomainMapper @Inject constructor() : (ResponseApi) -> Response {
    override fun invoke(responseApi: ResponseApi): Response {
        return Response(offers = responseApi.offers.map { offerApi ->
            Offer(
                id = offerApi.id,
                title = offerApi.title,
                link = offerApi.link,
                buttonText = offerApi.button?.text
            )
        }, vacancies = responseApi.vacancies.map { vacancyApi ->
            Vacancy(
                lookingNumber = vacancyApi.lookingNumber,
                title = vacancyApi.title,
                address = vacancyApi.address.town,
                company = vacancyApi.company,
                experience = vacancyApi.experience.previewText,
                publishedDate = vacancyApi.publishedDate,
                isFavorite = vacancyApi.isFavorite
            )
        })
    }
}