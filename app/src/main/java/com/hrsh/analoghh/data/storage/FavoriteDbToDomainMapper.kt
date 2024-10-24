package com.hrsh.analoghh.data.storage

import com.hrsh.analoghh.domain.entities.Favorite
import javax.inject.Inject

class FavoriteDbToDomainMapper @Inject constructor() : (FavoriteDb) -> Favorite {

    override fun invoke(favoriteDb: FavoriteDb): Favorite {
        return Favorite(
            id = favoriteDb.id,
            lookingNumber = favoriteDb.lookingNumber,
            title = favoriteDb.title,
            address = favoriteDb.address,
            company = favoriteDb.company,
            experience = favoriteDb.experience,
            publishedDate = favoriteDb.publishedDate,
        )
    }
}