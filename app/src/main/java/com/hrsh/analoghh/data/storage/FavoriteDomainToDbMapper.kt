package com.hrsh.analoghh.data.storage

import com.hrsh.analoghh.domain.entities.Favorite
import javax.inject.Inject

class FavoriteDomainToDbMapper @Inject constructor() : (Favorite) -> FavoriteDb {

    override fun invoke(favorite: Favorite): FavoriteDb {
        return FavoriteDb(
            id = favorite.id,
            lookingNumber = favorite.lookingNumber,
            title = favorite.title,
            address = favorite.address,
            company = favorite.company,
            experience = favorite.experience,
            publishedDate = favorite.publishedDate,
        )
    }
}