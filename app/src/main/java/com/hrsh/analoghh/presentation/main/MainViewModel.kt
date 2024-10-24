package com.hrsh.analoghh.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hrsh.analoghh.domain.entities.Favorite
import com.hrsh.analoghh.domain.entities.Offer
import com.hrsh.analoghh.domain.entities.Vacancy
import com.hrsh.analoghh.domain.usecases.DeleteFavoriteUseCase
import com.hrsh.analoghh.domain.usecases.InsertFavoriteUseCase
import com.hrsh.analoghh.domain.usecases.SubscribeFavoriteUseCase
import com.hrsh.analoghh.domain.usecases.SubscribeResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val subscribeResponseUseCase: SubscribeResponseUseCase,
    private val subscribeFavoriteUseCase: SubscribeFavoriteUseCase,
    private val insertFavoriteUseCase: InsertFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : ViewModel() {
    private val _offers: MutableStateFlow<List<Offer>> = MutableStateFlow(emptyList())
    val offers: StateFlow<List<Offer>> = _offers.asStateFlow()

    private val _vacancies: MutableStateFlow<List<Vacancy>> = MutableStateFlow(emptyList())
    val vacancies: StateFlow<List<Vacancy>> = _vacancies.asStateFlow()

    private val _favoriteVacancies: MutableStateFlow<List<Favorite>> = MutableStateFlow(emptyList())
    val favoriteVacancies: StateFlow<List<Favorite>> = _favoriteVacancies.asStateFlow()

    init {
        viewModelScope.launch {
            val response = subscribeResponseUseCase.invoke()
            _offers.value = response.offers
            _vacancies.value = response.vacancies
            _favoriteVacancies.value = subscribeFavoriteUseCase.invoke()
        }
    }

    fun insertFavorite(favorite: Favorite) {
        viewModelScope.launch {
            insertFavoriteUseCase.invoke(favorite)
            _favoriteVacancies.value = subscribeFavoriteUseCase.invoke()
        }
    }

    fun deleteFavorite(favorite: Favorite) {
        viewModelScope.launch {
            deleteFavoriteUseCase.invoke(favorite)
            _favoriteVacancies.value = subscribeFavoriteUseCase.invoke()
        }
    }
}