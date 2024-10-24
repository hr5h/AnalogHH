package com.hrsh.analoghh.data.network.mappers

import com.hrsh.analoghh.data.network.entities.ResponseApi
import com.hrsh.analoghh.data.storage.FavoriteDb
import javax.inject.Inject

class ResponseApiToFavoriteDbMapper @Inject constructor() : (ResponseApi) -> List<FavoriteDb> {

    override fun invoke(responseApi: ResponseApi): List<FavoriteDb> {
        return responseApi.vacancies.map {
            FavoriteDb(
                id = null,
                lookingNumber = it.lookingNumber,
                title = it.title,
                address = it.address.town,
                company = it.company,
                experience = it.experience.previewText,
                publishedDate = it.publishedDate,
            )
        }
    }
}