package com.hrsh.analoghh.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hrsh.analoghh.domain.entities.Offer
import com.hrsh.analoghh.domain.usecases.SubscribeResponseUseCase
import com.hrsh.analoghh.domain.entities.Vacancy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val subscribeResponseUseCase: SubscribeResponseUseCase
): ViewModel() {
    private val _offers: MutableStateFlow<List<Offer>> = MutableStateFlow(emptyList())
    val offers: StateFlow<List<Offer>> = _offers.asStateFlow()

    private val _vacancies: MutableStateFlow<List<Vacancy>> = MutableStateFlow(emptyList())
    val vacancies: StateFlow<List<Vacancy>> = _vacancies.asStateFlow()

    private val _favoriteVacancies: MutableStateFlow<List<Vacancy>> = MutableStateFlow(emptyList())
    val favoriteVacancies: StateFlow<List<Vacancy>> = _favoriteVacancies.asStateFlow()

    init {
        viewModelScope.launch {
            val response = subscribeResponseUseCase.invoke()
            _offers.value = response.offers
            _vacancies.value = response.vacancies
            _favoriteVacancies.value = vacancies.value.filter { !it.isFavorite }
        }
    }
}