package com.hrsh.analoghh.data.repositories

import com.hrsh.analoghh.data.utils.InternetChecker
import com.hrsh.analoghh.data.network.mappers.ResponseApiToDomainMapper
import com.hrsh.analoghh.data.network.services.ResponseService
import com.hrsh.analoghh.data.storage.FavoritesDao
import com.hrsh.analoghh.data.network.mappers.ResponseApiToFavoriteDbMapper
import com.hrsh.analoghh.data.storage.FavoriteDb
import com.hrsh.analoghh.data.storage.FavoriteDbToDomainMapper
import com.hrsh.analoghh.data.storage.FavoriteDomainToDbMapper
import com.hrsh.analoghh.domain.entities.Favorite
import com.hrsh.analoghh.domain.entities.Response
import javax.inject.Inject

interface ResponseRepository {
    suspend fun getResponse(): Response
    suspend fun getFavorites(): List<Favorite>
    suspend fun postFavorite(favorite: Favorite)
    suspend fun deleteFavorite(favorite:Favorite)
}

class ResponseRepositoryImpl @Inject constructor(
    private val responseService: ResponseService,
    private val favoritesDao: FavoritesDao,
    private val responseApiToDomainMapper: ResponseApiToDomainMapper,
    private val responseApiToFavoriteDbMapper: ResponseApiToFavoriteDbMapper,
    private val favoriteDbToDomainMapper: FavoriteDbToDomainMapper,
    private val favoriteDomainToDbMapper: FavoriteDomainToDbMapper,
    private val internetChecker: InternetChecker,
): ResponseRepository {

    override suspend fun getResponse(): Response {
        if(internetChecker.isInternetAvailable()){
            val responseApi = responseService.getResponse()
            val favoritesVacancies = responseApi.vacancies.filter { it.isFavorite }
            favoritesVacancies.forEach { vacancy ->
                favoritesDao.insert(
                    FavoriteDb(id = 0,
                        lookingNumber = vacancy.lookingNumber,
                        title = vacancy.title,
                        address = vacancy.address.town,
                        company = vacancy.company,
                        experience = vacancy.experience.previewText,
                        publishedDate = vacancy.publishedDate,)
                )
            }
            return responseApiToDomainMapper.invoke(responseApi)
        }

        return Response(emptyList(), emptyList())
    }

    override suspend fun getFavorites(): List<Favorite> {
        val favorites = favoritesDao.getAll()
        return favorites.map(favoriteDbToDomainMapper)
    }

    override suspend fun postFavorite(favorite: Favorite) {
        val favoriteDb = favoriteDomainToDbMapper(favorite)
        favoritesDao.insert(favoriteDb)
    }

    override suspend fun deleteFavorite(favorite:Favorite) {
        val favoriteDb = favoriteDomainToDbMapper(favorite)
        favoritesDao.delete(favoriteDb)
    }
}